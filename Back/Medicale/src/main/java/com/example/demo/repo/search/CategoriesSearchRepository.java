package com.example.demo.repo.search;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.vente.Categories;

@Repository
public interface CategoriesSearchRepository extends JpaRepository<Categories, Integer> {
	@Query(value = "SELECT Nom FROM Categories")
	Optional<Categories> findByNom(String Nom);
}
