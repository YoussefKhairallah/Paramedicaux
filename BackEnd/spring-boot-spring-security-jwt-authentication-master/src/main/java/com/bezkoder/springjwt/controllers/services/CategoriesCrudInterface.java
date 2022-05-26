package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Categories;


public interface CategoriesCrudInterface {
	List<Categories> findAllCategories();
	 Optional<Categories> findCategoriesById(long id);
	 Categories AddCategories(Categories categories);
	 Categories UpdateCategories (long id, Categories categories);
void DeleteCategories(long categoriesid);
}
