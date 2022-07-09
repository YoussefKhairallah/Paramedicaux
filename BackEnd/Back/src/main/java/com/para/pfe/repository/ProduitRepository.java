package com.para.pfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.para.pfe.models.Produit;

public interface ProduitRepository  extends JpaRepository<Produit,Long> {
	
	List<Produit> findProduitsByCategoriesId(Long categorieId);
	
	@Query(
			  value = "SELECT pr.*,ca.nom as categorie FROM `categorie_produit` pc,`produits` pr,`categories` ca WHERE ca.id = pc.`categorie_id` AND pr.id = pc.`produit_id`", 
			  nativeQuery = true)
	List<Produit> findProduitsWithCategories();
	
	@Query(
			  value = "SELECT pr.*,ca.nom as categorie FROM `categorie_produit` pc,`produits` pr,`categories` ca WHERE ca.id = pc.`categorie_id` AND pr.id = pc.`produit_id`", 
			  nativeQuery = true)
	 Object findProduitAndCtegorie(Long id);
}
