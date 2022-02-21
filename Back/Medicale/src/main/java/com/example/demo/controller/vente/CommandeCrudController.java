package com.example.demo.controller.vente;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.services.vente.CommandeCrudImplement;
import com.example.demo.model.vente.Commande;

@RestController
@RequestMapping("/commande")
public class CommandeCrudController implements CommandeCrudControllerInterface {
	@Autowired
	CommandeCrudImplement CommandeCrud;
	
	@Override
	@GetMapping()
	public List<Commande> SearchAllCommande() {
		// TODO Auto-generated method stub
		return CommandeCrud.findAllCommande();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<Commande> SearchCommandeById(@PathVariable(value = "id") int id) {
		// TODO Auto-generated method stub
		return CommandeCrud.findCommandeById(id);
	}

	@Override
	@PostMapping()
	public Commande AddingCommande(@RequestBody @Valid Commande commande) {
		// TODO Auto-generated method stub
		return CommandeCrud.AddCommande(commande);
	}

	@Override
	@DeleteMapping("/{id}")
	public void DeletingCommande(@PathVariable(value = "id") int commadeid) {
		// TODO Auto-generated method stub
		CommandeCrud.DeleteCommande(commadeid);
	}

}
