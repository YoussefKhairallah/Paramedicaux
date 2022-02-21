package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Produit;

public interface ProduitCrudInterface {
	List<Produit>findallProduit();
	Optional<Produit>findProduitById(int id);
	Produit AddProduit(Produit produit);
	void DeleteProduit (int produitid);
}
