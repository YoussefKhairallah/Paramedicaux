package com.bezkoder.springjwt.controllers.user;

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

import com.bezkoder.springjwt.controllers.services.AvisCrudImplement;
import com.bezkoder.springjwt.models.Avis;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/avis")
public class AvisCrudController implements AvisCrudControllerInterfacer {
	@Autowired
	AvisCrudImplement avisCrud;
	
	@Override
	@GetMapping("/findAvis")
	public List<Avis> findAllAvis() {
		// TODO Auto-generated method stub
		return avisCrud.findAllAvis();
	}

	@Override
	@GetMapping("/findAvisById/{id}")
	public Optional<Avis> findAvisById(@PathVariable(value = "id") long id) {
		// TODO Auto-generated method stub
		return avisCrud.findAvisById(id);
	}

	@Override
	@PostMapping("/addAvis")
	public Avis AddingAvis(@RequestBody @Valid Avis avis) {
		// TODO Auto-generated method stub
		return avisCrud.AddAvis(avis);
	}

	@Override
	@DeleteMapping("/deletAvis/{id}")
	public void DeletingAvis(@PathVariable(value = "id") long avisid) {
		// TODO Auto-generated method stub
		avisCrud.DeleteAvis(avisid);
	}

	@Override
	@PutMapping("/updateAvis/{id}")
	public Avis UpdatedAvis(Avis avis, long id) {
		// TODO Auto-generated method stub
		return avisCrud.UpdateAvis(avis, id);
	}
	
}