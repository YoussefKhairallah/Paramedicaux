package com.para.pfe.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.para.pfe.exception.ResourceNotFoundException;
import com.para.pfe.models.Categorie;
import com.para.pfe.models.Produit;
import com.para.pfe.repository.CategorieRepository;
import com.para.pfe.repository.ProduitRepository;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200","http://localhost:6200"}, allowCredentials = "true")

@RestController
@RequestMapping("/api")
public class ProduitController {
	
	 @Autowired
	 private ProduitRepository produitrepo ;
	 
	 @Autowired
	 private CategorieRepository categorieRepository;
	 
	
	 @GetMapping("/produits")
	 public List<Produit> getAllProduits() {
	        return  (List<Produit>) produitrepo.findAll();
	    }


	    @GetMapping("/produits/{id}")
	    public ResponseEntity<Object> getProduitById(@PathVariable(value = "id") Long id)
	        throws ResourceNotFoundException {
	         Object produits = produitrepo.findById(id).get();
	        return ResponseEntity.ok().body(produits);
	    }
	    
	    @GetMapping("/categories/{categorieId}/produits")
	    public ResponseEntity<List<Produit>> getAllProduitByCategorielId(@PathVariable(value = "categorieId") Long categorieId) throws ResourceNotFoundException {
	    	/*
	      if (!categorieRepository.existsById(categorieId)) {
	        throw new ResourceNotFoundException("Not found Categorie with id = " + categorieId);
	      }
	      */

	      List<Produit> produit = produitrepo.findProduitsByCategoriesId(categorieId);
	      return new ResponseEntity<>(produit, HttpStatus.OK);
	    }
	   	   
	    
	    @PostMapping("/categories/{categorieId}/produits")
	    public ResponseEntity<Produit> addProduit(@PathVariable(value = "categorieId") Long categorieId, @RequestBody Produit produitRequest) throws ResourceNotFoundException {
	    	Categorie categorie = new Categorie();
	    	Produit pd=produitrepo.save(produitRequest);
	    	categorie = categorieRepository.findById(categorieId)
	    	          .orElseThrow(() -> new ResourceNotFoundException("Categories not found for this id :: " + categorieId));
	        
	        // add and create new Produit
	        //categorie.addProduit(pd);
	        //categorieRepository.save(categorie);
	    	categorie.getProduits().add(pd);
	    	pd.getCategories().add(categorie);
	    	categorieRepository.save(categorie);
	      
	      return new ResponseEntity<>(produitRequest, HttpStatus.CREATED);
	    }

	    @PutMapping("/produits/{id}")
	    public ResponseEntity<Produit> updateProduit(@PathVariable(value = "id") Long id,
	         @Valid @RequestBody Produit produitsDetails) throws ResourceNotFoundException {
	        Produit produits = produitrepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Produit not found for this id :: " + id));
			List<Long> catids=new ArrayList<Long>();
			produits.getCategories().forEach(c->{
				catids.add(c.getId());
			});
			long idc=catids.get(0);
			Categorie ca=categorieRepository.findById(idc).get();
			produits.getCategories().add(ca);
  
	        
	        produits.setNom(produitsDetails.getNom());
	        produits.setDescription(produitsDetails.getDescription());
	        produits.setPrix(produitsDetails.getPrix());
	        produits.setQte(produitsDetails.getQte());
	        produits.setQteLimite(produitsDetails.getQteLimite());
	        produits.setFournisseur(produitsDetails.getFournisseur());
	        produits.setImage(produitsDetails.getImage());

	         Produit updatedProduit = produitrepo.save(produits);
	        return ResponseEntity.ok(updatedProduit);
	    }

	    @DeleteMapping("/produits/{id}")
	    public Map<String, Boolean> deleteProduit(@PathVariable(value = "id") Long id)
	         throws ResourceNotFoundException {
	        Produit produits = produitrepo.findById(id)
	       .orElseThrow(() -> new ResourceNotFoundException("Produit not found for this id :: " + id));

	        produitrepo.delete(produits);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
