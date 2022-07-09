package com.para.pfe.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "produits")
public class Produit implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
	@NotEmpty(message="nom obligatoire")
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
	private String Prix;
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

	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "produits")
		  @JsonIgnore
    private List<Categorie> categories = new ArrayList<>();
	
	public Produit() {
		super();
	}
	
	

	public Produit(Long id, @NotEmpty(message = "nom obligatoire") @NotNull String nom, @NotNull int qte,
			@NotNull int qteLimite, @NotNull String prix, @NotNull String description, @NotBlank @NotNull String image,
			@NotBlank @NotNull String fournisseur, List<Categorie> categories) {
		super();
		this.id = id;
		Nom = nom;
		Qte = qte;
		QteLimite = qteLimite;
		Prix = prix;
		Description = description;
		Image = image;
		Fournisseur = fournisseur;
		this.categories = categories;
	}

	


	@Override
	public String toString() {
		return "Produit [id=" + id + ", Nom=" + Nom + ", Qte=" + Qte + ", QteLimite=" + QteLimite + ", Prix=" + Prix
				+ ", Description=" + Description + ", Image=" + Image + ", Fournisseur=" + Fournisseur + "]";
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	public String getPrix() {
		return Prix;
	}
	public void setPrix(String prix) {
		Prix = prix;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
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

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	
}
