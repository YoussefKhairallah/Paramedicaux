package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.vente.Panier;
import com.example.demo.repo.crud.PanierCrudRepository;

@Service
public class PanierCrudImplement implements PanierCrudInteface {
	
	@Autowired
	PanierCrudRepository painerapi;
	
	@Override
	public List<Panier> findAllPanier() {
		// TODO Auto-generated method stub
		return (List<Panier>) painerapi.findAll();
	}

	@Override
	public Optional<Panier> findPanierById(int id) {
		// TODO Auto-generated method stub
		return painerapi.findById(id);
	}

	@Override
	public Panier AddPainer(Panier panier) {
		// TODO Auto-generated method stub
		return painerapi.save(panier);
	}

	@Override
	public void DeletePanier(int panierid) {
		// TODO Auto-generated method stub
		painerapi.deleteById(panierid);
	}

}
