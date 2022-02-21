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

import com.example.demo.controller.services.vente.LivraisonCrudImplement;
import com.example.demo.model.vente.Livraison;

@RestController
@RequestMapping("/livraison")
public class LivraisonCrudController implements LivraisonCrudControllerInterface {
	
	@Autowired
	LivraisonCrudImplement livraisonCrud;
	
	@Override
	@GetMapping()
	public List<Livraison> SearchAllLivraison() {
		// TODO Auto-generated method stub
		return livraisonCrud.findAllLivraison();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<Livraison> SearchLivraisonById(@PathVariable(value = "id") int id) {
		// TODO Auto-generated method stub
		return livraisonCrud.findLivraisonById(id);
	}

	@Override
	@PostMapping()
	public Livraison AddingLivraison(@RequestBody @Valid Livraison livraison) {
		// TODO Auto-generated method stub
		return livraisonCrud.AddLivraison(livraison);
	}

	@Override
	@DeleteMapping("/{id}")
	public void DeletingLivraison(@PathVariable(value = "id") int livraisonid) {
		// TODO Auto-generated method stub
		livraisonCrud.DeleteLivraison(livraisonid);
	}

}
