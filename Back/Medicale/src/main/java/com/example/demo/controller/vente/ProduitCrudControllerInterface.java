package com.example.demo.controller.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Produit;

public interface ProduitCrudControllerInterface {
	List<Produit>SearchAllProduit();
	Optional<Produit>SearchProduitById(int id);
	Produit AddingProduit(Produit produit);
	void DeletingProduit (int produitid);
}
