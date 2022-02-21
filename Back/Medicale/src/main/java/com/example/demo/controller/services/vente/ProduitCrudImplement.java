package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.vente.Produit;
import com.example.demo.repo.crud.ProduitCrudRepository;

@Service
public class ProduitCrudImplement implements ProduitCrudInterface {
	
	@Autowired
	ProduitCrudRepository produitapi;
	
	@Override
	public List<Produit> findallProduit() {
		// TODO Auto-generated method stub
		return (List<Produit>) produitapi.findAll();
	}

	@Override
	public Optional<Produit> findProduitById(int id) {
		// TODO Auto-generated method stub
		return produitapi.findById(id);
	}

	@Override
	public Produit AddProduit(Produit produit) {
		// TODO Auto-generated method stub
		return produitapi.save(produit);
	}

	@Override
	public void DeleteProduit(int produitid) {
		// TODO Auto-generated method stub
		produitapi.deleteById(produitid);
	}

}
