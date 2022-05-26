package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Produit;
import com.bezkoder.springjwt.repository.ProduitRepository;
@Service
public class ProduitCrudImplement implements ProduitCrudInterface {
	
	@Autowired
	ProduitRepository produitRepo;
	
	@Override
	public List<Produit> findAllProduit() {
		// TODO Auto-generated method stub
		return (List<Produit>) produitRepo.findAll();
	}

	@Override
	public Optional<Produit> findProduitById(long id) {
		// TODO Auto-generated method stub
		return produitRepo.findById(id);
	}

	@Override
	public Produit AddProduit(Produit produit) {
		// TODO Auto-generated method stub
		return produitRepo.save(produit);
	}

	
	@Override
	public void DeleteProduit(long produitid) {

		produitRepo.deleteById(produitid);
	}

	@Override
	public Produit UpdateProduit(long id, Produit produit) {

		return produitRepo.save(produit);
	}

}
