package com.example.demo.repo.search;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.vente.Produit;

@Repository
public interface ProduitSearchRepository extends JpaRepository<Produit, Integer> {
	@Query(value = "SELECT Nom FROM Produit")
	Optional<Produit> findByNom(String Nom);
	@Query(value = "SELECT Qte FROM Produit")
	Optional<Produit> findByQuantite(int Qte);
	@Query(value = "SELECT Prix FROM Produit")
	Optional<Produit> findByPrix(double Prix);
	@Query(value = "SELECT Description FROM Produit")
	Optional<Produit> findByDescription(String Desc);
	@Query(value = "SELECT Fournisseur FROM Produit")
	Optional<Produit> findByFourrnisseur(String Fournisseur);
	@Query(value = "SELECT Image FROM Produit")
	Optional<Produit> findByImage(String Image);	
}
