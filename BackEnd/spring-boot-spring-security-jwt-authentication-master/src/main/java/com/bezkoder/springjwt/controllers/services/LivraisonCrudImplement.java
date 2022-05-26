package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Livraison;
import com.bezkoder.springjwt.repository.LivraisonRepository;


@Service
public class LivraisonCrudImplement implements LivraisonCrudInterface {
	@Autowired
	LivraisonRepository livraisonCrud;
	
	@Override
	public List<Livraison> findAllLivraison() {
		// TODO Auto-generated method stub
		return (List<Livraison>) livraisonCrud.findAll();
	}

	@Override
	public Optional<Livraison> findLivraisonById(long id) {
		// TODO Auto-generated method stub
		return livraisonCrud.findById(id);
	}

	@Override
	public Livraison AddLivraison(Livraison livraison) {
		// TODO Auto-generated method stub
		return livraisonCrud.save(livraison);
	}

	@Override
	public void DeleteLivraison(long livraisonid) {
		// TODO Auto-generated method stub
		livraisonCrud.deleteById(livraisonid);
	}

	@Override
	public Livraison UpdateLivraison(Livraison livraison, long id) {
		// TODO Auto-generated method stub
		return livraisonCrud.save(livraison);
	}

}
