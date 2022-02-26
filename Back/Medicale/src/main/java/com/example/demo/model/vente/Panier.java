package com.example.demo.model.vente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private String ModePaiement;
	@NotBlank
	@NotNull
	private Date DateCreation;
	@NotBlank
	@NotNull
	private double TotalePrix;
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Panier(String modePaiement, Date dateCreation, double totalePrix) {
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
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
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
