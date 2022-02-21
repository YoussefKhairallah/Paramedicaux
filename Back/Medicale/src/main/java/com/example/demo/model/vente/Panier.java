package com.example.demo.model.vente;

import java.time.LocalDateTime;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 255)
	@NotBlank
	private String ModePaiement;
	@NotBlank
	private LocalDateTime DateCreation;
	@NotBlank
	private double TotalePrix;
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy = "panier")
	private List<Commande> commande;
	
	public Panier(String modePaiement, LocalDateTime dateCreation, double totalePrix) {
		super();
		ModePaiement = modePaiement;
		DateCreation = dateCreation;
		TotalePrix = totalePrix;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModePaiement() {
		return ModePaiement;
	}
	public void setModePaiement(String modePaiement) {
		ModePaiement = modePaiement;
	}
	public LocalDateTime getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(LocalDateTime dateCreation) {
		DateCreation = dateCreation;
	}
	public double getTotalePrix() {
		return TotalePrix;
	}
	public void setTotalePrix(double totalePrix) {
		TotalePrix = totalePrix;
	}

	@Override
	public String toString() {
		return "Panier [id=" + id + ", ModePaiement=" + ModePaiement + ", DateCreation=" + DateCreation
				+ ", TotalePrix=" + TotalePrix + "]";
	}
	
}
