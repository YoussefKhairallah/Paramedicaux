package com.para.pfe.controllers;

import com.para.pfe.exception.ResourceNotFoundException;
import com.para.pfe.models.Categorie;
import com.para.pfe.repository.CategorieRepository;
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



@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200"}, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class CategorieController {
     @Autowired
    private CategorieRepository CategorieRepository;
        
    @GetMapping("/categories")
    public List<Categorie> getAllCategories() {
        return  (List<Categorie>) CategorieRepository.findAll();
    }


    @GetMapping("/categories/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException {
        Categorie categories = CategorieRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Categories not found for this id :: " + id));
        return ResponseEntity.ok().body(categories);
    }
    
    @PostMapping("/categories")
    public Categorie createCategorie(@Valid @RequestBody Categorie categories) {
        return CategorieRepository.save(categories);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") Long id,
         @Valid @RequestBody Categorie categoriesDetails) throws ResourceNotFoundException {
        Categorie categories = CategorieRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Categories not found for this id :: " + id));
        
        categories.setNom(categoriesDetails.getNom());
        final Categorie updatedCategorie = CategorieRepository.save(categories);
        return ResponseEntity.ok(updatedCategorie);
    }

    @DeleteMapping("/categories/{id}")
    public Map<String, Boolean> deleteCategorie(@PathVariable(value = "id") Long id)
         throws ResourceNotFoundException {
        Categorie categories = CategorieRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Categories not found for this id :: " + id));

        CategorieRepository.delete(categories);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
