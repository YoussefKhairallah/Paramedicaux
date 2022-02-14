package com.Siteparamedicaux.demo.Table;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livraison {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date DateSortie;
	private String AdresseClient;
	private String FraisLiv;
	private String NbreJour;
	private String AdresseSociete;
	
	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livraison(Date dateSortie, String adresseClient, String fraisLiv, String nbreJour, String adresseSociete) {
		super();
		DateSortie = dateSortie;
		AdresseClient = adresseClient;
		FraisLiv = fraisLiv;
		NbreJour = nbreJour;
		AdresseSociete = adresseSociete;
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
	public String getFraisLiv() {
		return FraisLiv;
	}
	public void setFraisLiv(String fraisLiv) {
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

	@Override
	public String toString() {
		return "Livraison [id=" + id + ", DateSortie=" + DateSortie + ", AdresseClient=" + AdresseClient + ", FraisLiv="
				+ FraisLiv + ", NbreJour=" + NbreJour + ", AdresseSociete=" + AdresseSociete + "]";
	}
	
}
