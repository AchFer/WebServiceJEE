package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class valeurs implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date dateCreation;
	private String content;
	
	 @ManyToOne
	private Capteur capteur ;
	 
	public Capteur getCapteur() {
		return capteur;
	}
	public void setCapteur(Capteur capteur) {
		this.capteur = capteur;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation() {
		this.dateCreation =new Date();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
