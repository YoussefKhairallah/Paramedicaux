package com.bezkoder.springjwt.models;

import java.sql.Date;

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
@Table(name = "livraison")
public class Livraison {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@NotBlank
	@NotNull
	private Date DateSortie;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private String AdresseClient;
	//@NotBlank
	@NotNull
	private double FraisLiv;
	//@NotBlank
	@NotNull
	private int NbreJour;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private String AdresseSociete;
	@NotBlank
	@Column(length = 50)
	@NotNull
	private String Etat;
	
	@ManyToOne
	private User livreur;
	
	@ManyToOne
	private Commande commande;

	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livraison(Date dateSortie, String adresseClient, double fraisLiv, int nbreJour, String adresseSociete,String etat) {
		super();
		DateSortie = dateSortie;
		AdresseClient = adresseClient;
		FraisLiv = fraisLiv;
		NbreJour = nbreJour;
		AdresseSociete = adresseSociete;
		Etat = etat;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateSortie() {
		return DateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		DateSortie = dateSortie;
	}
	public String getAdresseClient() {
		return AdresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		AdresseClient = adresseClient;
	}
	public double getFraisLiv() {
		return FraisLiv;
	}
	public void setFraisLiv(double fraisLiv) {
		FraisLiv = fraisLiv;
	}
	public int getNbreJour() {
		return NbreJour;
	}
	public void setNbreJour(int nbreJour) {
		NbreJour = nbreJour;
	}
	public String getAdresseSociete() {
		return AdresseSociete;
	}
	public void setAdresseSociete(String adresseSociete) {
		AdresseSociete = adresseSociete;
	}
	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}
}
