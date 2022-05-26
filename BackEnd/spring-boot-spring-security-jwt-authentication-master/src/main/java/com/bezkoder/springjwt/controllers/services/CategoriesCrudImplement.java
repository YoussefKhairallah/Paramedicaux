package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Categories;
import com.bezkoder.springjwt.repository.CategoriesRepository;

@Service
public class CategoriesCrudImplement implements CategoriesCrudInterface {
	@Autowired
	CategoriesRepository categoriesCrud;
	
	@Override
	public List<Categories> findAllCategories() {
		// TODO Auto-generated method stub
		return (List<Categories>) categoriesCrud.findAll();
	}

	@Override
	public Optional<Categories> findCategoriesById(long id) {

		return categoriesCrud.findById(id);
	}

	@Override
	public Categories AddCategories(Categories categories) {

		return categoriesCrud.save(categories);
	}

	@Override
	public void DeleteCategories(long categoriesid) {

		categoriesCrud.deleteById(categoriesid);
	}

	@Override
	public Categories UpdateCategories(long id, Categories categories) {

		return categoriesCrud.save(categories);
	}

}
