package nc.noumea.mairie.kiosque.abs.dto;

/*
 * #%L
 * sirh-kiosque-j2ee
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2014 - 2015 Mairie de Nouméa
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

import java.util.List;

public class SaisieGardeDto {

	private List<AgentJoursFeriesGardeDto> listAgentAvecGarde;
	private List<JourDto> joursFerieHeader;

	public List<AgentJoursFeriesGardeDto> getListAgentAvecGarde() {
		return listAgentAvecGarde;
	}

	public void setListAgentAvecGarde(List<AgentJoursFeriesGardeDto> listAgentAvecGarde) {
		this.listAgentAvecGarde = listAgentAvecGarde;
	}

	public List<JourDto> getJoursFerieHeader() {
		return joursFerieHeader;
	}

	public void setJoursFerieHeader(List<JourDto> joursFerieHeader) {
		this.joursFerieHeader = joursFerieHeader;
	}
}
