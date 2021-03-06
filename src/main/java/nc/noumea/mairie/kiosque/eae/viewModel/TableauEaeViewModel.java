package nc.noumea.mairie.kiosque.eae.viewModel;

/*
 * #%L
 * sirh-kiosque-j2ee
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2014 Mairie de Nouméa
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Div;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import nc.noumea.mairie.kiosque.dto.ReturnMessageDto;
import nc.noumea.mairie.kiosque.eae.dto.EaeEtatEnum;
import nc.noumea.mairie.kiosque.eae.dto.EaeListItemDto;
import nc.noumea.mairie.kiosque.export.ExcelExporter;
import nc.noumea.mairie.kiosque.export.PdfExporter;
import nc.noumea.mairie.kiosque.profil.dto.ProfilAgentDto;
import nc.noumea.mairie.kiosque.validation.ValidationMessage;
import nc.noumea.mairie.ws.AlfrescoCMISService;
import nc.noumea.mairie.ws.ISirhEaeWSConsumer;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TableauEaeViewModel {

	private ProfilAgentDto			currentUser;

	@WireVariable
	private ISirhEaeWSConsumer		eaeWsConsumer;

	private List<EaeListItemDto>	tableauEae;

	private Div						divDepart;

	/* POUR LE HAUT DU TABLEAU */
	private String					filter;
	private String					tailleListe;

	@Init
	public void initTableauEae(@ExecutionArgParam("div") Div div) {
		setDivDepart(div);
		currentUser = (ProfilAgentDto) Sessions.getCurrent().getAttribute("currentUser");

		// on initialise la taille du tableau
		setTailleListe("10");
		filtrer();
	}

	@Command
	public void changerDelegataire(@BindingParam("ref") EaeListItemDto eae) {
		// create a window programmatically and use it as a modal dialog.
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("eae", eae);
		Window win = (Window) Executions.createComponents("/eae/changerDelegataire.zul", null, map);
		win.doModal();
	}

	@Command
	public void modifierEae(@BindingParam("ref") EaeListItemDto eae) {
		// create a window programmatically and use it as a modal dialog.
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("eae", eae);
		args.put("mode", "EDIT");
		getDivDepart().getChildren().clear();
		Executions.createComponents("/eae/onglet/eae.zul", getDivDepart(), args);
	}

	@Command
	public void voirEae(@BindingParam("ref") EaeListItemDto eae) {
		// create a window programmatically and use it as a modal dialog.
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("eae", eae);
		args.put("mode", "VIEW");
		getDivDepart().getChildren().clear();
		Executions.createComponents("/eae/onglet/eae.zul", getDivDepart(), args);
	}

	@Command
	public void imprimerEae(@BindingParam("ref") EaeListItemDto eae) {
		// on imprime l'EAE de l'agent
		byte[] resp = eaeWsConsumer.imprimerEAE(eae.getIdEae(), eae.isEstDetache());
		if (eae.isEstDetache()) {
			Filedownload.save(resp, "application/docx", "eae_" + eae.getIdEae());
		} else {
			Filedownload.save(resp, "application/pdf", "eae_" + eae.getIdEae());
		}

	}

	@Command
	@NotifyChange({ "tableauEae" })
	public void initialiserEae(@BindingParam("ref") EaeListItemDto eae) {

		ReturnMessageDto result = eaeWsConsumer.initialiseEae(currentUser.getAgent().getIdAgent(), eae.getAgentEvalue().getIdAgent());

		final HashMap<String, Object> map = new HashMap<String, Object>();
		List<ValidationMessage> listErreur = new ArrayList<ValidationMessage>();
		List<ValidationMessage> listInfo = new ArrayList<ValidationMessage>();
		for (String error : result.getErrors()) {
			ValidationMessage vm = new ValidationMessage(error);
			listErreur.add(vm);
		}
		for (String info : result.getInfos()) {
			ValidationMessage vm = new ValidationMessage(info);
			listInfo.add(vm);
		}
		map.put("errors", listErreur);
		map.put("infos", listInfo);
		if (listErreur.size() > 0 || listInfo.size() > 0) {
			Executions.createComponents("/messages/returnMessage.zul", null, map);
		}
		// on re-affiche le tableau des EAEs
		filtrer();
	}

	@Command
	@NotifyChange({ "tableauEae" })
	public void doSearch() {
		List<EaeListItemDto> list = new ArrayList<EaeListItemDto>();
		if (getFilter() != null && !"".equals(getFilter()) && getTableauEae() != null) {
			for (EaeListItemDto item : getTableauEae()) {
				// agent
				if (item.getAgentEvalue().getNom().toLowerCase().contains(getFilter().toLowerCase())) {
					if (!list.contains(item))
						list.add(item);
				}
				if (item.getAgentEvalue().getPrenom().toLowerCase().contains(getFilter().toLowerCase())) {
					if (!list.contains(item))
						list.add(item);
				}
				// shd
				if (item.getAgentShd().getNom().toLowerCase().contains(getFilter().toLowerCase())) {
					if (!list.contains(item))
						list.add(item);
				}
				if (item.getAgentShd().getPrenom().toLowerCase().contains(getFilter().toLowerCase())) {
					if (!list.contains(item))
						list.add(item);
				}
				// etat
				if (item.getEtat().toLowerCase().contains(getFilter().toLowerCase())) {
					if (!list.contains(item))
						list.add(item);
				}
			}
			setTableauEae(list);
		} else {
			filtrer();
		}
	}

	@GlobalCommand
	@NotifyChange({ "tableauEae" })
	public void filtrer() {
		// on recupère les info du tableau des EAEs
		List<EaeListItemDto> tableau = eaeWsConsumer.getTableauEae(currentUser.getAgent().getIdAgent());
		setTableauEae(tableau);
	}

	public String getEtat(String etat) {
		return EaeEtatEnum.getEtatFromCode(etat) == null ? "" : EaeEtatEnum.getEtatFromCode(etat).toString();
	}

	public String concatAgent(String nom, String prenom) {
		return nom + " " + prenom;
	}

	public String getDateToString(Date date) {
		if (date == null)
			return "N/A";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}

	@Command
	public void exportPDF(@BindingParam("ref") Listbox listbox) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		PdfExporter exporter = new PdfExporter();
		exporter.export(listbox, out);

		AMedia amedia = new AMedia("listeEae.pdf", "pdf", "application/pdf", out.toByteArray());
		Filedownload.save(amedia);
		out.close();
	}

	@Command
	public void exportExcel(@BindingParam("ref") Listbox listbox) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		ExcelExporter exporter = new ExcelExporter();
		exporter.export(listbox, out);

		AMedia amedia = new AMedia("listeEae.xlsx", "xls", "application/file", out.toByteArray());
		Filedownload.save(amedia);
		out.close();
	}

	public List<EaeListItemDto> getTableauEae() {
		return tableauEae;
	}

	public void setTableauEae(List<EaeListItemDto> tableauEae) {
		this.tableauEae = tableauEae;
	}

	public String getTailleListe() {
		return tailleListe;
	}

	public void setTailleListe(String tailleListe) {
		this.tailleListe = tailleListe;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public Div getDivDepart() {
		return divDepart;
	}

	public void setDivDepart(Div divDepart) {
		this.divDepart = divDepart;
	}

	public String getUrlFromAlfresco(EaeListItemDto dto) {
		if (dto == null || dto.getIdDocumentGed() == null) {
			return "";
		}
		return AlfrescoCMISService.getUrlOfDocument(dto.getIdDocumentGed());
	}
}
