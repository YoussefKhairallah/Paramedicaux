package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Panier;

public interface PanierCrudInteface {
	List<Panier> findAllPanier();
	 Optional<Panier> findPanierById(int id);
	 Panier AddPainer(Panier panier);
void DeletePanier(int panierid);
}
