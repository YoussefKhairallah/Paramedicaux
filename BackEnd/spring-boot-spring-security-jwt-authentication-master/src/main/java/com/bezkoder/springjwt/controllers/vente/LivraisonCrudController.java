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

import com.bezkoder.springjwt.controllers.services.LivraisonCrudImplement;
import com.bezkoder.springjwt.models.Livraison;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/livraison")
public class LivraisonCrudController implements LivraisonCrudControllerInterface {
	@Autowired
	LivraisonCrudImplement livraisonCrud;
	
	@Override
	@GetMapping("/findLivraison")
	public List<Livraison> findAllLivraison() {
		// TODO Auto-generated method stub
		return livraisonCrud.findAllLivraison();
	}

	@Override
	@GetMapping("/findLivraisonbyid/{id}")
	public Optional<Livraison> findLivraisonById(@PathVariable(value = "id") long id) {
		// TODO Auto-generated method stub
		return livraisonCrud.findLivraisonById(id);
	}

	@Override
	@PostMapping("/addLivraison")
	public Livraison AddingLivraison(@RequestBody @Valid Livraison livraison) {
		// TODO Auto-generated method stub
		return livraisonCrud.AddLivraison(livraison);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void DeletingLivraison(@PathVariable(value = "id") long livraisonid) {
		// TODO Auto-generated method stub
		livraisonCrud.DeleteLivraison(livraisonid);
	}

	@Override
	@PutMapping("updateLivraison/{id}")
	public Livraison UpdatedLivraison(Livraison livraison, long id) {
		// TODO Auto-generated method stub
		return livraisonCrud.UpdateLivraison(livraison, id);
	}

}