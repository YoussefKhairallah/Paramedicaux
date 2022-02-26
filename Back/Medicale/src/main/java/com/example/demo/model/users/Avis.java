package com.example.demo.model.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;
import com.example.demo.model.vente.Produit;


@Entity
public class Avis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@NotBlank
	private String Description;
	@NotBlank
	@NotNull
	private Date Date;

	@ManyToOne
	private User client;
	
	@ManyToOne
	private Produit produit;
	
	
	public Avis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avis(@NotBlank String description, @NotBlank Date date) {
		super();
		Description = description;
		Date = date;
	
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDesc() {
		return Description;
	}


	public void setDesc(String description) {
		this.Description = description;
	}


	public Date getDate() {
		return Date;
	}


	public void setDate(Date date) {
		this.Date = date;
	}


	public User getUser() {
		return client;
	}


	public void setUser(User client) {
		this.client = client;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	@Override
	public String toString() {
		return "Avis [id=" + id + ", description=" + Description + ", Date=" + Date + "]";
	}
	
	
}
