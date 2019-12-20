package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.jms.JMSSessionMode;
import javax.persistence.*;

import org.omg.CosNaming.NamingContextOperations;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Maison
 *
 */
@Entity

public class Maison implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Adresse;
	private String image;
	@OneToOne
	private utilisateur utilisateur;
	
	@JsonIgnore
	@OneToMany(mappedBy = "maison")
	private List<Noeud> noeuds ; 
	
	

	public Maison() {
		super();
	}   
	
	

	


	public Maison(int idMai, String adresse, entities.utilisateur utilisateur, List<Noeud> noeuds) {
		super();
		this.id = idMai;
		Adresse = adresse;
		this.utilisateur = utilisateur;
		this.noeuds = noeuds;
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






	public List<Noeud> getNoeuds() {
		return noeuds;
	}

	public void setNoeuds(List<Noeud> noeuds) {
		this.noeuds = noeuds;
	}

	public utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getIdMai() {
		return this.id;
	}

	public void setIdMai(int idMai) {
		this.id = idMai;
	}   
	public String getAdresse() {
		return this.Adresse;
	}

	public void setAdresse(String Adresse) {
		this.Adresse = Adresse;
	}
   
}
