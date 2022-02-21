package com.example.demo.controller.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Panier;

public interface PanierCrudControllerInterface {
	List<Panier> searchAllPanier();
	 Optional<Panier> searchPanierById(int id);
	 Panier AddingPanier(Panier panier);
void DeletingPanier(int panierid);
}
