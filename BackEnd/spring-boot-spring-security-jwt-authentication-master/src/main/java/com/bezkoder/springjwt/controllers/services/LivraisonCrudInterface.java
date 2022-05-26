package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Livraison;

public interface LivraisonCrudInterface {
	List<Livraison> findAllLivraison();
	Optional<Livraison> findLivraisonById(long id);
	Livraison AddLivraison(Livraison livraison);
	Livraison UpdateLivraison(Livraison livraison, long id);
	void DeleteLivraison (long livraisonid);
}
