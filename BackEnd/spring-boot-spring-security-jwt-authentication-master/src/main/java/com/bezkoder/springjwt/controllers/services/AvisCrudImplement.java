package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Avis;
import com.bezkoder.springjwt.repository.AvisRepository;

@Service
public class AvisCrudImplement implements AvisCrudInterface {
	@Autowired
	AvisRepository avisRepo;
	
	@Override
	public List<Avis> findAllAvis() {
		// TODO Auto-generated method stub
		return (List<Avis>) avisRepo.findAll();
	}

	@Override
	public Optional<Avis> findAvisById(long id) {
		// TODO Auto-generated method stub
		return avisRepo.findById(id);
	}

	@Override
	public Avis AddAvis(Avis avis) {
		// TODO Auto-generated method stub
		return avisRepo.save(avis);
	}

	@Override
	public void DeleteAvis(long avisid) {
		avisRepo.deleteById(avisid);

	}

	@Override
	public Avis UpdateAvis(Avis avis, long id) {
		
		return avisRepo.save(avis);
	}

}
