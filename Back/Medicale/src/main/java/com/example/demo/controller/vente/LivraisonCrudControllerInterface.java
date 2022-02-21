package com.example.demo.controller.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Livraison;

public interface LivraisonCrudControllerInterface {
	List<Livraison> SearchAllLivraison();
	Optional<Livraison> SearchLivraisonById(int id);
	Livraison AddingLivraison(Livraison livraison);
	void DeletingLivraison (int livraisonid);
}
