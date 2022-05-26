package com.bezkoder.springjwt.controllers.vente;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Categories;


public interface CategoriesCrudControllerInterface {
	List<Categories> findAllCategories();
	Optional<Categories> findCategoriesById(long id);
	Categories AddingCategories(Categories categories);
	Categories UpdatedCategories (long id, Categories categories);
	void DeletingCategories(long categoriesid);
}
