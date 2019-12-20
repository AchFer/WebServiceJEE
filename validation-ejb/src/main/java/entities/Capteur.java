package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Capteur
 *
 */
@Entity

public class Capteur implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCap;
	private String nomCapteur;
	private String reference;
	@JsonIgnore
	@OneToMany(mappedBy = "capteur")
	private  List<valeurs> valeur;
	@ManyToOne 
	private Noeud noeuds ; 


	public Capteur() {
		super();
	}
	


	

	public Noeud getNoeuds() {
		return noeuds;
	}

	public void setNoeuds(Noeud noeuds) {
		this.noeuds = noeuds;
	}
	



	



	

	public Capteur(int idCap, String nomCapteur, String reference, List<valeurs> valeur, Noeud noeuds) {
		super();
		this.idCap = idCap;
		this.nomCapteur = nomCapteur;
		this.reference = reference;
		this.valeur = valeur;
		this.noeuds = noeuds;
	}





	public int getIdCap() {
		return this.idCap;
	}

	public void setIdCap(int idCap) {
		this.idCap = idCap;
	}

	public String getNomCapteur() {
		return this.nomCapteur;
	}

	public void setNomCapteur(String nomCapteur) {
		this.nomCapteur = nomCapteur;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
