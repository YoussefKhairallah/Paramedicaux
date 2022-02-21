package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.vente.Commande;
import com.example.demo.repo.crud.CommandeCrudRepository;

@Service
public class CommandeCrudImplement implements CommandeCrudInerface {
	
	@Autowired
	CommandeCrudRepository commandeapi;
	
	@Override
	public List<Commande> findAllCommande() {
		// TODO Auto-generated method stub
		return (List<Commande>) commandeapi.findAll();
	}

	@Override
	public Optional<Commande> findCommandeById(int id) {
		// TODO Auto-generated method stub
		return commandeapi.findById(id);
	}

	@Override
	public Commande AddCommande(Commande commande) {
		// TODO Auto-generated method stub
		return commandeapi.save(commande);
	}

	@Override
	public void DeleteCommande(int commandeid) {
		// TODO Auto-generated method stub
		commandeapi.deleteById(commandeid);
	}

}
