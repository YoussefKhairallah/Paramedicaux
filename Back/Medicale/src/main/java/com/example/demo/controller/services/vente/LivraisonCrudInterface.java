package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Livraison;

public interface LivraisonCrudInterface {
	List<Livraison> findAllLivraison();
	Optional<Livraison> findLivraisonById(int id);
	Livraison AddLivraison(Livraison livraison);
	void DeleteLivraison (int livraisonid);
}
