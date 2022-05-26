package com.bezkoder.springjwt.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private  String Nom;
	//@NotBlank
	@NotNull
	private int Qte;
	//@NotBlank
	@NotNull
	private int QteLimite;
	//@NotBlank
	@NotNull
	private double Prix;
	@Column(length = 255)
	//@NotBlank
	@NotNull
	private String Description;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private String Image;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private String Fournisseur;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private Set<Categories> categorie;
	
	public Produit() {
		super();
	}
	
	public Produit(String nom, int qte, double prix, String description, String image, String fournisseur, int qteLimite) {
		super();
		Nom = nom;
		Qte = qte;
		Prix = prix;
		Description = description;
		Image = image;
		Fournisseur = fournisseur;
		QteLimite = qteLimite;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public int getQte() {
		return Qte;
	}
	public void setQte(int qte) {
		Qte = qte;
	}
	public double getPrix() {
		return Prix;
	}
	public void setPrix(double prix) {
		Prix = prix;
	}
	public String getDesc() {
		return Description;
	}
	public void setDesc(String description) {
		Description = description;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getFournisseur() {
		return Fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		Fournisseur = fournisseur;
	}
	public int getQteLimite() {
		return QteLimite;
	}

	public void setQteLimite(int qteLimite) {
		QteLimite = qteLimite;
	}
}
