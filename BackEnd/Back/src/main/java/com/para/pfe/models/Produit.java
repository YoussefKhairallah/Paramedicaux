package com.para.pfe.models;

import java.util.HashSet;
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
public class Produit {

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
		  private Set<Categorie> categories = new HashSet<>();
	
	public Produit() {
		super();
	}
	
	public Produit(String nom, int qte, String prix, String description, String image, String fournisseur, int qteLimite) {
		super();
		Nom = nom;
		Qte = qte;
		Prix = prix;
		Description = description;
		Image = image;
		Fournisseur = fournisseur;
		QteLimite = qteLimite;
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
	 public Set<Categorie> getCategories() {
		    return categories;
		  }

		  public void setCategories(Set<Categorie> categories) {
		    this.categories = categories;
		  }  
}
