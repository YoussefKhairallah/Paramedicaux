package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.vente.Categories;
import com.example.demo.repo.crud.CategoriesCrudRepository;

@Service
public class CategoriesCrudImplement implements CategoriesCrudInterface {

	@Autowired
	CategoriesCrudRepository categoriesapi;
	
	@Override
	public List<Categories> findAllCategories() {
		// TODO Auto-generated method stub
		return (List<Categories>) categoriesapi.findAll();
	}

	@Override
	public Optional<Categories> findCategoriesById(int id) {
		// TODO Auto-generated method stub
		return categoriesapi.findById(id);
	}

	@Override
	public Categories AddCategories(Categories categories) {
		// TODO Auto-generated method stub
		return categoriesapi.save(categories);
	}

	@Override
	public void DeleteCategories(int categoriesid) {
		// TODO Auto-generated method stub
		categoriesapi.deleteById(categoriesid);
	}

}
