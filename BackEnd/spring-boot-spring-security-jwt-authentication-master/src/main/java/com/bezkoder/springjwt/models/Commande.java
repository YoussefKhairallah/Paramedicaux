package com.bezkoder.springjwt.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private String Adresse;
	@NotBlank
	@NotNull
	private double PrixTotale;
	//@NotBlank
	@NotNull
	private int Qte;
	@Column(length = 50)
	@NotBlank
	@NotNull
	private String Etat;
	@NotBlank
	@NotNull
	private String Date;
	
	@ManyToOne
	private User client;
	
	@ManyToOne
	private Produit produit;
	
	public Commande() {
		super();
	}
	
	
	public Commande(String adresse, double prixTotale, int qte, String etat, String date) {
		super();
		Adresse = adresse;
		PrixTotale = prixTotale;
		Qte = qte;
		Etat = etat;
		Date = date;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public double getPrixTotale() {
		return PrixTotale;
	}
	public void setPrixTotale(double prixTotale) {
		PrixTotale = prixTotale;
	}
	public int getQte() {
		return Qte;
	}
	public void setQte(int qte) {
		Qte = qte;
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
}