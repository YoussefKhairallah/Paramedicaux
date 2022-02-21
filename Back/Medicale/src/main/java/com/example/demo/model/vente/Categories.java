package com.example.demo.model.vente;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
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

	public int getId() {
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

	@Override
	public String toString() {
		return "Categories [id=" + id + ", Nom=" + Nom + "]";
	}
	
}
