package com.para.pfe.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.para.pfe.models.Categorie;

public interface CategorieRepository  extends JpaRepository<Categorie, Long>{

	  List<Categorie> findByNom(String nom);
	  
}
