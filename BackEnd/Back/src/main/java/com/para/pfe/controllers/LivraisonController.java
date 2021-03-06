package com.para.pfe.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.para.pfe.models.Livraison;
import com.para.pfe.repository.LivraisonRepository;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200","http://localhost:6200"}, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class LivraisonController {
	 @Autowired
	    private LivraisonRepository LivraisonRepository;
	        
	    @GetMapping("/livraison")
	    public List<Livraison> getAllLivraisons() {
	        return  (List<Livraison>) LivraisonRepository.findAll();
	    }


	    @GetMapping("/livraison/{id}")
	    public ResponseEntity<Livraison> getLivraisonById(@PathVariable(value = "id") Long id)
	        throws ResourceNotFoundException {
	        Livraison livraison = LivraisonRepository.findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("Livraison not found for this id :: " + id));
	        return ResponseEntity.ok().body(livraison);
	    }
	    
	    @PostMapping("/livraison")
	    public Livraison createLivraison(@Valid @RequestBody Livraison livraison) {
	        return LivraisonRepository.save(livraison);
	    }

	    @PutMapping("/livraison/{id}")
	    public ResponseEntity<Livraison> updateLivraison(@PathVariable(value = "id") Long id,
	         @Valid @RequestBody Livraison livraisonDetails) throws ResourceNotFoundException {
	        Livraison livraison = LivraisonRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Livraison not found for this id :: " + id));
	        
	        

	        final Livraison updatedLivraison = LivraisonRepository.save(livraison);
	        return ResponseEntity.ok(updatedLivraison);
	    }

	    @DeleteMapping("/livraison/{id}")
	    public Map<String, Boolean> deleteLivraison(@PathVariable(value = "id") Long id)
	         throws ResourceNotFoundException {
	        Livraison livraison = LivraisonRepository.findById(id)
	       .orElseThrow(() -> new ResourceNotFoundException("Livraison not found for this id :: " + id));

	        LivraisonRepository.delete(livraison);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
