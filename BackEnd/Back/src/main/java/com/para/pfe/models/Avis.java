package com.para.pfe.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "avis", uniqueConstraints = {
		@UniqueConstraint(columnNames = {
			"id"
		})
})

public class Avis {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotNull
	@NotBlank
	private String Description;
	
	@NotNull
	private String Date;
    
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_produit", nullable =false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Produit produit;  
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_client", nullable =false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    public User client;

  

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


	public User getClient() {
		return client;
	}


	public void setClient(User client) {
		this.client = client;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
