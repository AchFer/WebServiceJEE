package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Reclamation implements Serializable{

@Id
@GeneratedValue(strategy=GenerationType.AUTO)	
private int idRec;
private String description;
private String nom_rec;

@JsonIgnore
@ManyToOne
private utilisateur utilisateur;

public int getIdRec() {
	return idRec;
}
public void setIdRec(int idRec) {
	this.idRec = idRec;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getNom_rec() {
	return nom_rec;
}
public void setNom_rec(String nom_rec) {
	this.nom_rec = nom_rec;
}
public utilisateur getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
public Reclamation() {
	super();
}
public Reclamation(int idRec, String description, String nom_rec, entities.utilisateur utilisateur) {
	super();
	this.idRec = idRec;
	this.description = description;
	this.nom_rec = nom_rec;
	this.utilisateur = utilisateur;
}


}
