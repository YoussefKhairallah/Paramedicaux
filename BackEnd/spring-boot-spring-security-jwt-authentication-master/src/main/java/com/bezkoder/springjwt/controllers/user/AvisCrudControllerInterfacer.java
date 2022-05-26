package com.bezkoder.springjwt.controllers.user;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Avis;


public interface AvisCrudControllerInterfacer {
	List<Avis> findAllAvis();
	Optional<Avis> findAvisById(long id);
	Avis AddingAvis(Avis avis);
	 Avis UpdatedAvis (Avis avis, long id);
void DeletingAvis(long avisid);
}

