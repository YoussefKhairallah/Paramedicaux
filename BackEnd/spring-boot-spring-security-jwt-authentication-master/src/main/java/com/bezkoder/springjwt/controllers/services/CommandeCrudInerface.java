package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Commande;


public interface CommandeCrudInerface {
	List<Commande> findAllCommande();
	Optional<Commande> findCommandeById(long id);
	Commande AddCommande(Commande commande);
	Commande UpdateCommande( long id, Commande commande);
	void DeleteCommande (long commandeid);
}
