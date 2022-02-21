package com.example.demo.controller.vente;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.vente.Categories;

public interface CategoriesCrudControllerInterface {
	List<Categories> searchAllCategories();
	Optional<Categories> searchCategoriesById(int id);
	Categories AddingCategories(Categories categories);
	void DeletingCategories(int categoriesid);
}
