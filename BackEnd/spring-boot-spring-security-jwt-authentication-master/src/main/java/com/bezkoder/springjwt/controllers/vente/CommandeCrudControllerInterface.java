package com.bezkoder.springjwt.controllers.vente;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Commande;


public interface CommandeCrudControllerInterface {
	List<Commande>findAllCommande();
	Optional<Commande>findCommandeById(long id);
	Commande AddingCommande(Commande commande);
	Commande UpdatedCommande(long id, Commande commande);
	void DeletingCommande(long commadeid);
}
