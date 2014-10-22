package nc.noumea.mairie.kiosque.eae.dto;

import java.util.Date;
import java.util.List;

public class EaeEvolutionDto {

	private int idEae;
	private boolean autrePerspective;
	private boolean changementMetier;
	private boolean concours;
	private boolean mobiliteAutre;
	private boolean mobiliteCollectivite;
	private boolean mobiliteDirection;
	private boolean mobiliteFonctionnelle;
	private boolean mobiliteGeo;
	private boolean mobiliteService;
	private boolean retraite;
	private boolean tempsPartiel;
	private boolean vae;
	private String commentaireEvaluateur;
	private String commentaireEvalue;
	private String commentaireEvolution;
	private Date dateRetraite;
	private EaeListeDto delaiEnvisage;
	private List<EaeDeveloppementDto> developpementCompetences;
	private List<EaeDeveloppementDto> developpementComportement;
	private List<EaeDeveloppementDto> developpementConnaissances;
	private List<EaeDeveloppementDto> developpementExamensConcours;
	private List<EaeDeveloppementDto> developpementFormateur;
	private List<EaeDeveloppementDto> developpementPersonnel;
	private String libelleAutrePerspective;
	private String nomCollectivite;
	private String nomConcours;
	private String nomVae;
	private EaeListeDto pourcentageTempsPartiel;
	private List<EaeSouhaitDto> souhaitsSuggestions;

	public int getIdEae() {
		return idEae;
	}

	public void setIdEae(int idEae) {
		this.idEae = idEae;
	}

	public boolean getAutrePerspective() {
		return autrePerspective;
	}

	public void setAutrePerspective(boolean autrePerspective) {
		this.autrePerspective = autrePerspective;
	}

	public String getChangementMetier() {
		return String.valueOf(changementMetier);
	}

	public void setChangementMetier(String changementMetier) {
		this.changementMetier = Boolean.parseBoolean(changementMetier);
	}

	public boolean getConcours() {
		return concours;
	}

	public void setConcours(boolean concours) {
		this.concours = concours;
	}

	public String getMobiliteAutre() {
		return String.valueOf(mobiliteAutre);
	}

	public void setMobiliteAutre(String mobiliteAutre) {
		this.mobiliteAutre = Boolean.parseBoolean(mobiliteAutre);
	}

	public String getMobiliteCollectivite() {
		return String.valueOf(mobiliteCollectivite);
	}

	public void setMobiliteCollectivite(String mobiliteCollectivite) {
		this.mobiliteCollectivite = Boolean.parseBoolean(mobiliteCollectivite);
	}

	public String getMobiliteDirection() {
		return String.valueOf(mobiliteDirection);
	}

	public void setMobiliteDirection(String mobiliteDirection) {
		this.mobiliteDirection = Boolean.parseBoolean(mobiliteDirection);
	}

	public String getMobiliteFonctionnelle() {
		return String.valueOf(mobiliteFonctionnelle);
	}

	public void setMobiliteFonctionnelle(String mobiliteFonctionnelle) {
		this.mobiliteFonctionnelle = Boolean.parseBoolean(mobiliteFonctionnelle);
	}

	public String getMobiliteGeo() {
		return String.valueOf(mobiliteGeo);
	}

	public void setMobiliteGeo(String mobiliteGeo) {
		this.mobiliteGeo = Boolean.parseBoolean(mobiliteGeo);
	}

	public String getMobiliteService() {
		return String.valueOf(mobiliteService);
	}

	public void setMobiliteService(String mobiliteService) {
		this.mobiliteService = Boolean.parseBoolean(mobiliteService);
	}

	public boolean getRetraite() {
		return retraite;
	}

	public void setRetraite(boolean retraite) {
		this.retraite = retraite;
	}

	public boolean getTempsPartiel() {
		return tempsPartiel;
	}

	public void setTempsPartiel(boolean tempsPartiel) {
		this.tempsPartiel = tempsPartiel;
	}

	public boolean getVae() {
		return vae;
	}

	public void setVae(boolean vae) {
		this.vae = vae;
	}

	public String getCommentaireEvaluateur() {
		return commentaireEvaluateur;
	}

	public void setCommentaireEvaluateur(String commentaireEvaluateur) {
		this.commentaireEvaluateur = commentaireEvaluateur;
	}

	public String getCommentaireEvalue() {
		return commentaireEvalue;
	}

	public void setCommentaireEvalue(String commentaireEvalue) {
		this.commentaireEvalue = commentaireEvalue;
	}

	public String getCommentaireEvolution() {
		return commentaireEvolution;
	}

	public void setCommentaireEvolution(String commentaireEvolution) {
		this.commentaireEvolution = commentaireEvolution;
	}

	public Date getDateRetraite() {
		return dateRetraite;
	}

	public void setDateRetraite(Date dateRetraite) {
		this.dateRetraite = dateRetraite;
	}

	public EaeListeDto getDelaiEnvisage() {
		return delaiEnvisage;
	}

	public void setDelaiEnvisage(EaeListeDto delaiEnvisage) {
		this.delaiEnvisage = delaiEnvisage;
	}

	public List<EaeDeveloppementDto> getDeveloppementCompetences() {
		return developpementCompetences;
	}

	public void setDeveloppementCompetences(List<EaeDeveloppementDto> developpementCompetences) {
		this.developpementCompetences = developpementCompetences;
	}

	public List<EaeDeveloppementDto> getDeveloppementComportement() {
		return developpementComportement;
	}

	public void setDeveloppementComportement(List<EaeDeveloppementDto> developpementComportement) {
		this.developpementComportement = developpementComportement;
	}

	public List<EaeDeveloppementDto> getDeveloppementConnaissances() {
		return developpementConnaissances;
	}

	public void setDeveloppementConnaissances(List<EaeDeveloppementDto> developpementConnaissances) {
		this.developpementConnaissances = developpementConnaissances;
	}

	public List<EaeDeveloppementDto> getDeveloppementExamensConcours() {
		return developpementExamensConcours;
	}

	public void setDeveloppementExamensConcours(List<EaeDeveloppementDto> developpementExamensConcours) {
		this.developpementExamensConcours = developpementExamensConcours;
	}

	public List<EaeDeveloppementDto> getDeveloppementFormateur() {
		return developpementFormateur;
	}

	public void setDeveloppementFormateur(List<EaeDeveloppementDto> developpementFormateur) {
		this.developpementFormateur = developpementFormateur;
	}

	public List<EaeDeveloppementDto> getDeveloppementPersonnel() {
		return developpementPersonnel;
	}

	public void setDeveloppementPersonnel(List<EaeDeveloppementDto> developpementPersonnel) {
		this.developpementPersonnel = developpementPersonnel;
	}

	public String getLibelleAutrePerspective() {
		return libelleAutrePerspective;
	}

	public void setLibelleAutrePerspective(String libelleAutrePerspective) {
		this.libelleAutrePerspective = libelleAutrePerspective;
	}

	public String getNomCollectivite() {
		return nomCollectivite;
	}

	public void setNomCollectivite(String nomCollectivite) {
		this.nomCollectivite = nomCollectivite;
	}

	public String getNomConcours() {
		return nomConcours;
	}

	public void setNomConcours(String nomConcours) {
		this.nomConcours = nomConcours;
	}

	public String getNomVae() {
		return nomVae;
	}

	public void setNomVae(String nomVae) {
		this.nomVae = nomVae;
	}

	public EaeListeDto getPourcentageTempsPartiel() {
		return pourcentageTempsPartiel;
	}

	public void setPourcentageTempsPartiel(EaeListeDto pourcentageTempsPartiel) {
		this.pourcentageTempsPartiel = pourcentageTempsPartiel;
	}

	public List<EaeSouhaitDto> getSouhaitsSuggestions() {
		return souhaitsSuggestions;
	}

	public void setSouhaitsSuggestions(List<EaeSouhaitDto> souhaitsSuggestions) {
		this.souhaitsSuggestions = souhaitsSuggestions;
	}

	public boolean isChangementMetier() {
		return changementMetier;
	}

	public boolean isMobiliteAutre() {
		return mobiliteAutre;
	}

	public boolean isMobiliteCollectivite() {
		return mobiliteCollectivite;
	}

	public boolean isMobiliteDirection() {
		return mobiliteDirection;
	}

	public boolean isMobiliteFonctionnelle() {
		return mobiliteFonctionnelle;
	}

	public boolean isMobiliteGeo() {
		return mobiliteGeo;
	}

	public boolean isMobiliteService() {
		return mobiliteService;
	}

	public void setChangementMetier(boolean changementMetier) {
		this.changementMetier = changementMetier;
	}

	public void setMobiliteAutre(boolean mobiliteAutre) {
		this.mobiliteAutre = mobiliteAutre;
	}

	public void setMobiliteCollectivite(boolean mobiliteCollectivite) {
		this.mobiliteCollectivite = mobiliteCollectivite;
	}

	public void setMobiliteDirection(boolean mobiliteDirection) {
		this.mobiliteDirection = mobiliteDirection;
	}

	public void setMobiliteFonctionnelle(boolean mobiliteFonctionnelle) {
		this.mobiliteFonctionnelle = mobiliteFonctionnelle;
	}

	public void setMobiliteGeo(boolean mobiliteGeo) {
		this.mobiliteGeo = mobiliteGeo;
	}

	public void setMobiliteService(boolean mobiliteService) {
		this.mobiliteService = mobiliteService;
	}

}
