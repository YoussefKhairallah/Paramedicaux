package com.example.demo.controller.services.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Categories;

public interface CategoriesCrudInterface {
	List<Categories> findAllCategories();
	 Optional<Categories> findCategoriesById(int id);
	 Categories AddCategories(Categories categories);
void DeleteCategories(int categoriesid);
}
