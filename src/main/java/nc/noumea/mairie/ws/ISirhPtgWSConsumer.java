package nc.noumea.mairie.ws;

import java.util.Date;
import java.util.List;

import nc.noumea.mairie.kiosque.abs.dto.ServiceDto;
import nc.noumea.mairie.kiosque.dto.AgentDto;
import nc.noumea.mairie.kiosque.dto.ReturnMessageDto;
import nc.noumea.mairie.kiosque.ptg.dto.AccessRightsPtgDto;
import nc.noumea.mairie.kiosque.ptg.dto.ConsultPointageDto;
import nc.noumea.mairie.kiosque.ptg.dto.DelegatorAndOperatorsDto;
import nc.noumea.mairie.kiosque.ptg.dto.FichePointageDto;
import nc.noumea.mairie.kiosque.ptg.dto.PointagesEtatChangeDto;
import nc.noumea.mairie.kiosque.ptg.dto.RefEtatPointageDto;
import nc.noumea.mairie.kiosque.ptg.dto.RefTypePointageDto;

public interface ISirhPtgWSConsumer {

	FichePointageDto getFichePointageSaisie(Integer idAgent, Date date, Integer idAgentConcerne);

	/* FILTRES */
	List<ServiceDto> getServicesPointages(Integer idAgent);

	List<RefEtatPointageDto> getEtatPointageKiosque();

	List<RefTypePointageDto> getTypePointageKiosque();

	List<AgentDto> getAgentsPointages(Integer idAgent, String codeService);

	/* DROITS */
	DelegatorAndOperatorsDto getDelegateAndOperator(Integer idAgent);

	List<AgentDto> getApprovedAgents(Integer idAgent);

	ReturnMessageDto saveApprovedAgents(Integer idAgent, List<AgentDto> listSelect);

	ReturnMessageDto saveDelegateAndOperator(Integer idAgent, DelegatorAndOperatorsDto dto);

	AccessRightsPtgDto getListAccessRightsByAgent(Integer idAgent);

	List<AgentDto> getAgentsSaisisOperateur(Integer idAgent, Integer idOperateur);

	ReturnMessageDto saveAgentsSaisisOperateur(Integer idAgent, Integer idOperateur, List<AgentDto> listSelect);

	/* IMPRESSION */
	List<AgentDto> getFichesToPrint(Integer idAgent, String codeService);

	byte[] imprimerFiches(Integer idAgent, Date dateLundi, List<String> listeIdAgentsToPrint);

	/* GESTION POINTAGES */
	List<ConsultPointageDto> getListePointages(Integer idAgentConnecte, Date fromDate, Date toDate,
 String codeService,
			Integer idAgentRecherche, Integer idEtat, Integer idType, String typeHS);

	ReturnMessageDto changerEtatPointage(Integer idAgent, List<PointagesEtatChangeDto> listeChangeEtat);

}
