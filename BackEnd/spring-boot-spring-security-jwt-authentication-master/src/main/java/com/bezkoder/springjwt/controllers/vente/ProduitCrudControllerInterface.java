package com.bezkoder.springjwt.controllers.vente;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Produit;


public interface ProduitCrudControllerInterface {
	List<Produit>findAllProduit();
	Optional<Produit>findProduitById(long id);
	Produit AddingProduit(Produit produit);
	Produit UpdatedProduit(long id, Produit produit);
	void DeletingProduit (long produitid);
}
