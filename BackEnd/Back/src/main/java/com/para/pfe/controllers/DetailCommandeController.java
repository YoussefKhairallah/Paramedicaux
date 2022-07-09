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
import com.para.pfe.models.DetailCommande;
import com.para.pfe.repository.DetailCommandeRepository;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200","http://localhost:6200"}, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class DetailCommandeController {
    
    @Autowired
    private DetailCommandeRepository DetailCommandeRepository;
        
    @GetMapping("/detailcommande")
    public List<DetailCommande> getAllDetailCommande() {
        return  (List<DetailCommande>) DetailCommandeRepository.findAll();
        
    }


    @GetMapping("/detailcommande/{id}")
    public ResponseEntity<DetailCommande> getDetailCommandeById(@PathVariable(value = "id") Long username)
        throws ResourceNotFoundException {
        DetailCommande devis = DetailCommandeRepository.findById(username)
          .orElseThrow(() -> new ResourceNotFoundException("Detail Commande not found for this id :: " + username));
        return ResponseEntity.ok().body(devis);
    }
    
    
    
    @PostMapping("/detailcommande")
    public DetailCommande createDetailCommande(@Valid @RequestBody DetailCommande devis) {
        return DetailCommandeRepository.save(devis);
    }

    @PutMapping("/detailcommande/{id}")
    public ResponseEntity<DetailCommande> updateDetailCommande(@PathVariable(value = "id") Long username,
         @Valid @RequestBody DetailCommande devisDetails) throws ResourceNotFoundException {
        DetailCommande devis = DetailCommandeRepository.findById(username)
        .orElseThrow(() -> new ResourceNotFoundException("DetailCommande not found for this id :: " + username));

        DetailCommande updatedDetailCommande = DetailCommandeRepository.save(devis);
        return ResponseEntity.ok(updatedDetailCommande);
    }

    @DeleteMapping("/detailcommande/{id}")
    public Map<String, Boolean> deleteDetailCommande(@PathVariable(value = "id") Long username)
         throws ResourceNotFoundException {
        DetailCommande devis = DetailCommandeRepository.findById(username)
       .orElseThrow(() -> new ResourceNotFoundException("DetailCommande not found for this id :: " + username));

        DetailCommandeRepository.delete(devis);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

