package com.example.demo.controller.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.users.Avis;

public interface AvisCrudControllerInterfacer {
	List<Avis> searchAllAvis();
	Optional<Avis> searchAvisById(int id);
	Avis AddingAvis(Avis avis);
void DeletingAvis(int avisid);
}
