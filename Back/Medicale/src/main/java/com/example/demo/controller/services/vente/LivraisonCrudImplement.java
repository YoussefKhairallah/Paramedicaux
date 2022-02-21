package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.vente.Livraison;
import com.example.demo.repo.crud.LivraisonCrudRepository;

@Service
public class LivraisonCrudImplement implements LivraisonCrudInterface {
	
	@Autowired
	LivraisonCrudRepository livraisonapi;
	
	@Override
	public List<Livraison> findAllLivraison() {
		// TODO Auto-generated method stub
		return (List<Livraison>) livraisonapi.findAll();
	}

	@Override
	public Optional<Livraison> findLivraisonById(int id) {
		// TODO Auto-generated method stub
		return livraisonapi.findById(id);
	}

	@Override
	public Livraison AddLivraison(Livraison livraison) {
		// TODO Auto-generated method stub
		return livraisonapi.save(livraison);
	}

	@Override
	public void DeleteLivraison(int livraisonid) {
		// TODO Auto-generated method stub
		livraisonapi.deleteById(livraisonid);
	}
}
