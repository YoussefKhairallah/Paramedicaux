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
import com.para.pfe.models.Commande;
import com.para.pfe.repository.CommandeRepository;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200","http://localhost:6200"}, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class CommandeController {

	@Autowired
    private CommandeRepository CommandeRepository;
        
    @GetMapping("/commande")
    public List<Commande> getAllCommande() {
        return  (List<Commande>) CommandeRepository.findAll();
        //return (List<Commande>) CommandeRepository.findAll();
    }


    @GetMapping("/commande/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable(value = "id") Long username)
        throws ResourceNotFoundException {
        Commande devis = CommandeRepository.findById(username)
          .orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: " + username));
        return ResponseEntity.ok().body(devis);
    }
    
    
    
    @PostMapping("/commande")
    public Commande createCommande(@Valid @RequestBody Commande devis) {
        return CommandeRepository.save(devis);
    }

    @PutMapping("/commande/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable(value = "id") Long username,
         @Valid @RequestBody Commande devisDetails) throws ResourceNotFoundException {
        Commande devis = CommandeRepository.findById(username)
        .orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: " + username));

        devis.setDate(devisDetails.getDate());
        devis.setEtat(devisDetails.getEtat());

        Commande updatedCommande = CommandeRepository.save(devis);
        return ResponseEntity.ok(updatedCommande);
    }

    @DeleteMapping("/commande/{id}")
    public Map<String, Boolean> deleteCommande(@PathVariable(value = "id") Long username)
         throws ResourceNotFoundException {
        Commande devis = CommandeRepository.findById(username)
       .orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: " + username));

        CommandeRepository.delete(devis);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
