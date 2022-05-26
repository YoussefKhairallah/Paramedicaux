package com.bezkoder.springjwt.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Categories;


public interface CategoriesRepository extends JpaRepository<Categories, Long> {



	
}
