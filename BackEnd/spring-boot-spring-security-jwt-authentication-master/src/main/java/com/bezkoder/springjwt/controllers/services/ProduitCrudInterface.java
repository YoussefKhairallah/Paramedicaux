package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Produit;


public interface ProduitCrudInterface {
	List<Produit>findAllProduit();
	Optional<Produit>findProduitById(long id);
	Produit AddProduit(Produit produit);
	Produit UpdateProduit(long id, Produit produit);
	void DeleteProduit (long produitid);
}
