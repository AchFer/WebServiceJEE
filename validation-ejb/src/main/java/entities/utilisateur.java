package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: utilisateur
 *
 */
@Entity
public class utilisateur implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Nom;
	private String Prenom;
	private String password;
	private String image;
	private String Email;
	@JsonIgnore
	@OneToOne(mappedBy="utilisateur") 
	private Maison maison;
	
	
	@OneToMany(mappedBy = "utilisateur",fetch=FetchType.EAGER)
	private List<Reclamation> Reclamations ; 
	

	
	

	public List<Reclamation> getReclamations() {
		return Reclamations;
	}




	public void setReclamations(List<Reclamation> reclamations) {
		Reclamations = reclamations;
	}




	public utilisateur() {
		super();
	}
	
	

	
	public utilisateur(int id, String nom, String prenom, String email, Maison maison) {
		super();
		this.id = id;
		Nom = nom;
		Prenom = prenom;
		Email = email;
		this.maison = maison;
	}




	public String getPassword() {
		return password;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}   
	public String getPrenom() {
		return this.Prenom;
	}

	public void setPrenom(String Prenom) {
		this.Prenom = Prenom;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
   
}
