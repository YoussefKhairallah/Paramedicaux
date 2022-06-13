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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "detailcommande", uniqueConstraints = {
		@UniqueConstraint(columnNames = {
			"id"
		})
})
public class DetailCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int qte;

    private double total;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_commande", nullable =false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Commande commande;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_produit", nullable =false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Produit produit;
    

    public DetailCommande() { super(); }

    public DetailCommande(int qte, double total, Commande commande, Produit produit) {
        super();
        this.qte = qte;
        this.total = total;
        this.commande = commande;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }   

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

}
