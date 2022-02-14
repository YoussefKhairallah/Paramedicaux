package com.Siteparamedicaux.demo.Table;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ModePaiement;
	private LocalDateTime DateCreation;
	private float TotalePrix;
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Panier(String modePaiement, LocalDateTime dateCreation, float totalePrix) {
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
	public float getTotalePrix() {
		return TotalePrix;
	}
	public void setTotalePrix(float totalePrix) {
		TotalePrix = totalePrix;
	}

	@Override
	public String toString() {
		return "Panier [id=" + id + ", ModePaiement=" + ModePaiement + ", DateCreation=" + DateCreation
				+ ", TotalePrix=" + TotalePrix + "]";
	}
	
}
