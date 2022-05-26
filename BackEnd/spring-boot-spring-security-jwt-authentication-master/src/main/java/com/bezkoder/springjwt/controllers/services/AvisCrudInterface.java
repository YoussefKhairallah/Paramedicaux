package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Avis;


public interface AvisCrudInterface {
	  List<Avis> findAllAvis();
		 Optional<Avis> findAvisById(long id);
		 Avis AddAvis(Avis avis);
		 Avis UpdateAvis (Avis avis, long id);
	void DeleteAvis(long avisid);
}
