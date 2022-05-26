package com.bezkoder.springjwt.controllers.vente;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Livraison;



public interface LivraisonCrudControllerInterface {
	List<Livraison> findAllLivraison();
	Optional<Livraison> findLivraisonById(long id);
	Livraison AddingLivraison(Livraison livraison);
	Livraison UpdatedLivraison(Livraison livraison, long id);
	void DeletingLivraison (long livraisonid);
}
