package com.example.demo.repo.search;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.vente.Produit;

@Repository
public interface ProduitSearchRepository extends JpaRepository<Produit, Integer> {
	@Query(value = "SELECT Nom FROM Produit")
	Optional<Produit> SearchByNom(String Nom);
	@Query(value = "SELECT Qte FROM Produit")
	Optional<Produit> SearchByQuantite(int Qte);
	@Query(value = "SELECT Prix FROM Produit")
	Optional<Produit> SearchByPrix(double Prix);
	@Query(value = "SELECT Description FROM Produit")
	Optional<Produit> SearchByDescription(String Desc);
	@Query(value = "SELECT Fournisseur FROM Produit")
	Optional<Produit> SearchByFourrnisseur(String Fournisseur);
	@Query(value = "SELECT Image FROM Produit")
	Optional<Produit> SearchByImage(String Image);	
}
