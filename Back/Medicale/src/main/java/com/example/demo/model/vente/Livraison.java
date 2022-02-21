package com.example.demo.model.vente;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Livraison {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private Date DateSortie;
	@Column(length = 255)
	@NotBlank
	private String AdresseClient;
	@NotBlank
	private float FraisLiv;
	@Column(length = 50)
	@NotBlank
	private String NbreJour;
	@Column(length = 255)
	@NotBlank
	private String AdresseSociete;
	@NotBlank
	@Column(length = 50)
	private String Etat;
	

	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livraison(Date dateSortie, String adresseClient, float fraisLiv, String nbreJour, String adresseSociete,String etat) {
		super();
		DateSortie = dateSortie;
		AdresseClient = adresseClient;
		FraisLiv = fraisLiv;
		NbreJour = nbreJour;
		AdresseSociete = adresseSociete;
		Etat = etat;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public float getFraisLiv() {
		return FraisLiv;
	}
	public void setFraisLiv(float fraisLiv) {
		FraisLiv = fraisLiv;
	}
	public String getNbreJour() {
		return NbreJour;
	}
	public void setNbreJour(String nbreJour) {
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

	@Override
	public String toString() {
		return "Livraison [id=" + id + ", DateSortie=" + DateSortie + ", AdresseClient=" + AdresseClient + ", FraisLiv="
				+ FraisLiv + ", NbreJour=" + NbreJour + ", AdresseSociete=" + AdresseSociete + ", Etat=" + Etat + "]";
	}
	

}
