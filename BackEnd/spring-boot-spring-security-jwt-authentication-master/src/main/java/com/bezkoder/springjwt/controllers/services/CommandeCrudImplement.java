package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Commande;
import com.bezkoder.springjwt.repository.CommandeRepository;


@Service
public class CommandeCrudImplement implements CommandeCrudInerface {
	@Autowired
	CommandeRepository commandeCrud;
	
	@Override
	public List<Commande> findAllCommande() {
		// TODO Auto-generated method stub
		return (List<Commande>) commandeCrud.findAll();
	}

	@Override
	public Optional<Commande> findCommandeById(long id) {
		// TODO Auto-generated method stub
		return commandeCrud.findById(id);
	}

	@Override
	public Commande AddCommande(Commande commande) {
		// TODO Auto-generated method stub
		return commandeCrud.save(commande);
	}

	@Override
	public void DeleteCommande(long commandeid) {
		// TODO Auto-generated method stub
		commandeCrud.deleteById(commandeid);
	}

	@Override
	public Commande UpdateCommande( long id, Commande commande) {
	
		return commandeCrud.save(commande);
	}

}
