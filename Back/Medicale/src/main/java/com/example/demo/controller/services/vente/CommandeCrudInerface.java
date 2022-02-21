package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Commande;

public interface CommandeCrudInerface {
	List<Commande> findAllCommande();
	Optional<Commande> findCommandeById(int id);
	Commande AddCommande(Commande commande);
	void DeleteCommande (int commandeid);
}
