package com.para.pfe.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "commande")
public class Commande {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
   
	private String adresse;

	private double prix_totale;
	
	private String etat;
	
	private String date;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User id_client;

    
    
    
    


	public Commande() {
	}
	
	
	

	public Commande(@NotBlank @NotNull String adresse, @NotNull double prix_totale, @NotBlank @NotNull String etat,
			@NotBlank @NotNull String date, User id_client) {
		this.adresse = adresse;
		this.prix_totale = prix_totale;
		this.etat = etat;
		this.date = date;
		this.id_client = id_client;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	

	public double getPrix_totale() {
		return prix_totale;
	}


	public void setPrix_totale(double prix_totale) {
		this.prix_totale = prix_totale;
	}


	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}




	public User getId_client() {
		return id_client;
	}




	public void setId_client(User id_client) {
		this.id_client = id_client;
	}


	
}
