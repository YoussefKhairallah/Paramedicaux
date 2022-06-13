package com.para.pfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.para.pfe.models.Produit;

public interface ProduitRepository  extends JpaRepository<Produit,Long> {
	
	List<Produit> findProduitsByCategoriesId(Long categorieId);
}
