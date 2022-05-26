package com.bezkoder.springjwt.controllers.vente;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.controllers.services.CommandeCrudImplement;
import com.bezkoder.springjwt.models.Commande;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/commande")
public class CommandeCrudController implements CommandeCrudControllerInterface {
	@Autowired
	CommandeCrudImplement CommandeCrud;
	
	@Override
	@GetMapping("/findCommande")
	public List<Commande> findAllCommande() {
	
		return CommandeCrud.findAllCommande();
	}

	@Override
	@GetMapping("findCommandeById/{id}")
	public Optional<Commande> findCommandeById(@PathVariable(value = "id") long id) {
		
		return CommandeCrud.findCommandeById(id);
	}

	@Override
	@PostMapping("/addCommande")
	public Commande AddingCommande(@RequestBody @Valid Commande commande) {
		
		return CommandeCrud.AddCommande(commande);
	}

	@Override
	@DeleteMapping("/deleteCommande/{id}")
	public void DeletingCommande(@PathVariable(value = "id") long commadeid) {
	
		CommandeCrud.DeleteCommande(commadeid);
	}

	@Override
	@PutMapping("updateCommande/{id}")
	public Commande UpdatedCommande(@PathVariable(value = "id") long id, @RequestBody @Valid Commande commande) {

		return CommandeCrud.UpdateCommande(id, commande);
	}

}
