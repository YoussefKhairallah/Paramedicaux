package com.example.demo.model.vente;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private  String Nom;
	@NotBlank
	@NotNull
	private int Qte;
	@NotBlank
	@NotNull
	private double Prix;
	@Column(length = 255)
	@NotBlank
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
	
	public Produit(String nom, int qte, double prix, String description, String image, String fournisseur) {
		super();
		Nom = nom;
		Qte = qte;
		Prix = prix;
		Description = description;
		Image = image;
		Fournisseur = fournisseur;
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

	@Override
	public String toString() {
		return "Produit [id=" + id + ", Nom=" + Nom + ", Qte=" + Qte + ", Prix=" + Prix + ", description=" + Description + ", Image="
				+ Image + ", Fournisseur=" + Fournisseur + "]";
	}

	public void setProduitCode(String string) {
		// TODO Auto-generated method stub
	}
	
}
