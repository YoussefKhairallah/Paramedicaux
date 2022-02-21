package com.example.demo.repo.search;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.vente.Produit;

public interface ProduitSearchRepository extends JpaRepository<Produit, Integer> {
	Optional<Produit> findByNom(String Nom);
	Optional<Produit> findByQuantite(int Qte);
	Optional<Produit> findByPrix(double Prix);
	Optional<Produit> findByDescription(String Desc);
	Optional<Produit> findByFournisseur(String Fournisseur);
	
}
