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
import com.para.pfe.models.Avis;
import com.para.pfe.repository.AvisRepository;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200"}, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class AvisController {

	@Autowired
    private AvisRepository AvisRepository;
        
    @GetMapping("/avis")
    public List<Avis> getAllAvis() {
        return  (List<Avis>) AvisRepository.findAll();
        //return (List<Avis>) AvisRepository.findAll();
    }


    @GetMapping("/avis/{id}")
    public ResponseEntity<Avis> getAvisById(@PathVariable(value = "id") Long username)
        throws ResourceNotFoundException {
        Avis devis = AvisRepository.findById(username)
          .orElseThrow(() -> new ResourceNotFoundException("Avis not found for this id :: " + username));
        return ResponseEntity.ok().body(devis);
    }
    
    
    
    @PostMapping("/avis")
    public Avis createAvis(@Valid @RequestBody Avis devis) {
        return AvisRepository.save(devis);
    }

    @PutMapping("/avis/{id}")
    public ResponseEntity<Avis> updateAvis(@PathVariable(value = "id") Long username,
         @Valid @RequestBody Avis devisDetails) throws ResourceNotFoundException {
        Avis devis = AvisRepository.findById(username)
        .orElseThrow(() -> new ResourceNotFoundException("Avis not found for this id :: " + username));

        devis.setDate(devisDetails.getDate());

        Avis updatedAvis = AvisRepository.save(devis);
        return ResponseEntity.ok(updatedAvis);
    }

    @DeleteMapping("/avis/{id}")
    public Map<String, Boolean> deleteAvis(@PathVariable(value = "id") Long username)
         throws ResourceNotFoundException {
        Avis devis = AvisRepository.findById(username)
       .orElseThrow(() -> new ResourceNotFoundException("Avis not found for this id :: " + username));

        AvisRepository.delete(devis);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
