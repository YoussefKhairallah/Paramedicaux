package com.bezkoder.springjwt.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "avis")
public class Avis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@NotBlank
	private String Description;
	@NotBlank
	@NotNull
	private String Date;

	@ManyToOne
	private User client;
	
	@ManyToOne
	private Produit produit;
	
	
	public Avis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avis(@NotBlank String description, @NotBlank String date) {
		super();
		Description = description;
		Date = date;
	
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDesc() {
		return Description;
	}


	public void setDesc(String description) {
		this.Description = description;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
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

}
