package com.example.demo.controller.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.users.Avis;
import com.example.demo.repo.crud.AvisCrudRepository;

@Service
public class AvisCrudImplement implements AvisCrudInterface {

	
	@Autowired
	AvisCrudRepository avisapi;
	
	@Override
	public List<Avis> findAllAvis() {
		// TODO Auto-generated method stub
		return (List<Avis>) avisapi.findAll();
	}

	@Override
	public Optional<Avis> findAvisById(int id) {
		// TODO Auto-generated method stub
		return avisapi.findById(id);
	}

	@Override
	public Avis AddAvis(Avis avis) {
		// TODO Auto-generated method stub
		return avisapi.save(avis);
	}

	@Override
	public void DeleteAvis(int avisid) {
		// TODO Auto-generated method stub
		avisapi.deleteById(avisid);
	}

}
