package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.jms.JMSSessionMode;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Noeud
 *
 */
@Entity

public class Noeud implements Serializable {

	
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@JsonIgnore
	@OneToMany(mappedBy = "noeuds",fetch=FetchType.EAGER)
	private List<Capteur> capteurs;
	private String NomNoeud;
	private String image;
	@ManyToOne
	private Maison maison ; 
	

	public Noeud() {
		super();
	}   
	
	public Noeud(String nomNoeud, int idNoe, List<Capteur> capteurs) {
		super();
		NomNoeud = nomNoeud;
		this.id = idNoe;
		this.capteurs = capteurs;
	}


	public List<Capteur> getCapteurs() {
		return capteurs;
	}
	

	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}

	public void setCapteurs(List<Capteur> capteurs) {
		this.capteurs = capteurs;
	}

	public String getNomNoeud() {
		return this.NomNoeud;
	}

	public void setNomNoeud(String NomNoeud) {
		this.NomNoeud = NomNoeud;
	}   
	public int getIdNoe() {
		return this.id;
	}

	public void setidNoe(int idNoe) {
		this.id = idNoe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
   
	
}
