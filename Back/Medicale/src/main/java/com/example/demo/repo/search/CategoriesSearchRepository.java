package com.example.demo.repo.search;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.vente.Categories;

public interface CategoriesSearchRepository extends JpaRepository<Categories, Integer> {
	Optional<Categories> findById(int id);
	Optional<Categories> findByNom(String Nom);
}
