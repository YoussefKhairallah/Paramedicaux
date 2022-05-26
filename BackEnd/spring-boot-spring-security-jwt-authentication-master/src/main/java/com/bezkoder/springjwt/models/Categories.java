package com.bezkoder.springjwt.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "categories")
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 50)
	@NotNull
	private String Nom;
	
	@ManyToMany(mappedBy = "categorie")
	private Set<Produit> produit;
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categories(String nom) {
		super();
		Nom = nom;
	}

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
}
