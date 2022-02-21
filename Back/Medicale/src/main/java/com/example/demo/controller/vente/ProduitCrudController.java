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

import com.example.demo.controller.services.vente.ProduitCrudImplement;
import com.example.demo.model.vente.Produit;

@RestController
@RequestMapping("/produit")
public class ProduitCrudController implements ProduitCrudControllerInterface {
	@Autowired
	ProduitCrudImplement produitCrud;
	
	@Override
	@GetMapping()
	public List<Produit> SearchAllProduit() {
		// TODO Auto-generated method stub
		return produitCrud.findallProduit();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<Produit> SearchProduitById(@PathVariable(value = "id") int id) {
		// TODO Auto-generated method stub
		return produitCrud.findProduitById(id);
	}
	@PostMapping()
	@Override
	public Produit AddingProduit(@RequestBody @Valid Produit produit) {
		// TODO Auto-generated method stub
		return produitCrud.AddProduit(produit);
	}
	
	@Override
	@DeleteMapping("/{id}")
	public void DeletingProduit(@PathVariable(value = "id") int produitid) {
		// TODO Auto-generated method stub
		produitCrud.DeleteProduit(produitid);
	}

}
