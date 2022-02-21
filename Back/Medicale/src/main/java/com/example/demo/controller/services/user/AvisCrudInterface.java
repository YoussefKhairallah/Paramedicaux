package com.example.demo.controller.services.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.users.Avis;

public interface AvisCrudInterface {
     List<Avis> findAllAvis();
	 Optional<Avis> findAvisById(int id);
	 Avis AddAvis(Avis avis);
void DeleteAvis(int avisid);

}
