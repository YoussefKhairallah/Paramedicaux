package com.example.demo.model.vente;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 255)
	@NotBlank
	private String Adresse;
	@NotBlank
	private double PrixTotale;
	@NotBlank
	private int Qte;
	@Column(length = 50)
	@NotBlank
	private String Etat;
	@NotBlank
	private LocalDateTime Date;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne
	private Panier panier;
	
	public Commande(String adresse, double prixTotale, int qte, String etat, LocalDateTime date) {
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
