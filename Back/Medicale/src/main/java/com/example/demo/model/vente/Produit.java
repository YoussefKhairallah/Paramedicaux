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


@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 255)
	@NotBlank
	private  String Nom;
	@NotBlank
	private int Qte;
	@NotBlank
	private double Prix;
	@Column(length = 255)
	@NotBlank
	private String Desc;
	@Column(length = 255)
	@NotBlank
	private String Image;
	@Column(length = 255)
	@NotBlank
	private String Fournisseur;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private Set<Categories> categorie;
	
	public Produit() {
		super();
	}
	
	public Produit(String nom, int qte, double prix, String desc, String image, String fournisseur) {
		super();
		Nom = nom;
		Qte = qte;
		Prix = prix;
		Desc = desc;
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
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
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
		return "Produit [id=" + id + ", Nom=" + Nom + ", Qte=" + Qte + ", Prix=" + Prix + ", Desc=" + Desc + ", Image="
				+ Image + ", Fournisseur=" + Fournisseur + "]";
	}

	public void setProduitCode(String string) {
		// TODO Auto-generated method stub
	}
	
}
