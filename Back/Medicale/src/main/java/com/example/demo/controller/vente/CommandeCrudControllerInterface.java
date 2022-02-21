package com.example.demo.controller.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Commande;

public interface CommandeCrudControllerInterface {
	List<Commande>SearchAllCommande();
	Optional<Commande>SearchCommandeById(int id);
	Commande AddingCommande(Commande commande);
	void DeletingCommande(int commadeid);
}
