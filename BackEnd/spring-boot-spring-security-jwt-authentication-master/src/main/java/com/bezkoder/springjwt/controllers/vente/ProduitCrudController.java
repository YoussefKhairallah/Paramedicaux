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

import com.bezkoder.springjwt.controllers.services.ProduitCrudImplement;
import com.bezkoder.springjwt.models.Produit;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/produit")
public class ProduitCrudController implements ProduitCrudControllerInterface {
	@Autowired
	ProduitCrudImplement produitCrud;
	
	@Override
	@GetMapping("/findproduits")
	public List<Produit> findAllProduit() {

		return produitCrud.findAllProduit();
	}

	@Override
	@GetMapping("/findproduitbyid/{id}")
	public Optional<Produit> findProduitById(@PathVariable(value = "id") long id) {

		return produitCrud.findProduitById(id);
	}

	@Override
	@PostMapping("/addProduct")
	public Produit AddingProduit(@RequestBody @Valid Produit produit) {

		return produitCrud.AddProduit(produit);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void DeletingProduit(@PathVariable(value = "id") long produitid) {
	
		produitCrud.DeleteProduit(produitid);
	}

	@Override
	@PutMapping("updateProduit/{id}")
	public Produit UpdatedProduit(@PathVariable(value = "id") long id,  @Valid @RequestBody Produit produit) {
	
		return produitCrud.UpdateProduit(id, produit);
	}

}