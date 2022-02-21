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

import com.example.demo.controller.services.vente.PanierCrudImplement;
import com.example.demo.model.vente.Panier;

@RestController
@RequestMapping("/panier")
public class PanierCrudController implements PanierCrudControllerInterface {
	
	@Autowired
	PanierCrudImplement panierCrud;
	
	@Override
	@GetMapping()
	public List<Panier> searchAllPanier() {
		// TODO Auto-generated method stub
		return panierCrud.findAllPanier();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<Panier> searchPanierById(@PathVariable(value = "id") int id) {
		// TODO Auto-generated method stub
		return panierCrud.findPanierById(id);
	}

	@Override
	@PostMapping()
	public Panier AddingPanier(@RequestBody @Valid Panier panier) {
		// TODO Auto-generated method stub
		return panierCrud.AddPainer(panier);
	}

	@Override
	@DeleteMapping("/{id}")
	public void DeletingPanier(@PathVariable(value = "id") int panierid) {
		// TODO Auto-generated method stub
		panierCrud.DeletePanier(panierid);
	}

}
