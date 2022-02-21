package com.example.demo.controller.user;

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

import com.example.demo.controller.services.user.AvisCrudImplement;
import com.example.demo.model.users.Avis;

@RestController
@RequestMapping("/avis")
public class AvisCrudController implements AvisCrudControllerInterfacer {

	@Autowired
	AvisCrudImplement avisCrud;
	
	@Override
	@GetMapping
	public List<Avis> searchAllAvis() {
		// TODO Auto-generated method stub
		return avisCrud.findAllAvis();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<Avis> searchAvisById(@PathVariable(value = "id") int id) {
		// TODO Auto-generated method stub
		return avisCrud.findAvisById(id);
	}

	@Override
	@PostMapping()
	public Avis AddingAvis(@RequestBody @Valid Avis avis) {
		// TODO Auto-generated method stub
		return avisCrud.AddAvis(avis);
	}

	@Override
	@DeleteMapping("/{id}")
	public void DeletingAvis(@PathVariable(value = "id") int avisid) {
		// TODO Auto-generated method stub
		avisCrud.DeleteAvis(avisid);

	}

}
