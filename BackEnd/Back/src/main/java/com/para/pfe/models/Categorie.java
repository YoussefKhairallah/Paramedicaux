package com.para.pfe.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categories", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "nom"
        })
})
public class Categorie {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
	@NotNull
	private String nom;
	
    @ManyToMany(fetch = FetchType.LAZY,
    	      cascade = {
    	          CascadeType.PERSIST,
    	          CascadeType.MERGE
    	      })
    	  @JoinTable(name = "produit_categorie",
    	        joinColumns = { @JoinColumn(name = "categorie_id") },
    	        inverseJoinColumns = { @JoinColumn(name = "produit_id") })
    	  private Set<Produit> produits = new HashSet<>();
	
	public Categorie() {
		
	}
	
	
	public Categorie(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(int id) {
		this.id = (long) id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	 public Set<Produit> getProduits() {
		    return produits;
		  }

		  public void setProduits(Set<Produit> produits) {
		    this.produits = produits;
		  }
		  
		  public void addProduit(Produit produit) {
		    this.produits.add(produit);
		    produit.getCategories().add(this);
		  }
		  
		  public void removeProduit(long produits) {
		    Produit produit = this.produits.stream().filter(t -> t.getId() == produits).findFirst().orElse(null);
		    if (produit != null) {
		      this.produits.remove(produit);
		      produit.getCategories().remove(this);
		    }
		  }
}
