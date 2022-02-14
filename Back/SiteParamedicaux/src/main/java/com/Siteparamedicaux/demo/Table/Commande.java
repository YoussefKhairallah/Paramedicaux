package com.Siteparamedicaux.demo.Table;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Adresse;
	private float PrixTotale;
	private int Qte;
	private String Etat;
	private LocalDateTime Date;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Commande(String adresse, float prixTotale, int qte, String etat, LocalDateTime date) {
		super();
		Adresse = adresse;
		PrixTotale = prixTotale;
		Qte = qte;
		Etat = etat;
		Date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public float getPrixTotale() {
		return PrixTotale;
	}
	public void setPrixTotale(float prixTotale) {
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
	public LocalDateTime getDate() {
		return Date;
	}
	public void setDate(LocalDateTime date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", Adresse=" + Adresse + ", PrixTotale=" + PrixTotale + ", Qte=" + Qte + ", Etat="
				+ Etat + ", Date=" + Date + "]";
	}
	
}
