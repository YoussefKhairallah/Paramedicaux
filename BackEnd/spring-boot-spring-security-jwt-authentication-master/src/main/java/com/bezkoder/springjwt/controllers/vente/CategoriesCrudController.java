package com.bezkoder.springjwt.controllers.vente;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.controllers.services.CategoriesCrudImplement;
import com.bezkoder.springjwt.models.Categories;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/categories")
public class CategoriesCrudController implements CategoriesCrudControllerInterface {
	@Autowired
	CategoriesCrudImplement categoriesCrud;
	
	@Override
	@GetMapping("/findcategories")
	public List<Categories> findAllCategories() {
		return categoriesCrud.findAllCategories();
	}

	@Override
	@GetMapping("/findcategoriesbyid/{id}")
	public Optional<Categories> findCategoriesById(@PathVariable(value = "id") long id) {

		return categoriesCrud.findCategoriesById(id);
	}
	

	@Override
	@PostMapping("/addcategorie")
	public Categories AddingCategories(@RequestBody @Valid Categories categories) {
		return categoriesCrud.AddCategories(categories);
	}
	

	@Override
	@DeleteMapping("deletecategorie/{id}")
	public void DeletingCategories(@PathVariable(value = "id") long categoriesid) {
		categoriesCrud.DeleteCategories(categoriesid);
	}


	@PutMapping("updateCategories/{id}")
	public Categories UpdatedCategories(@PathVariable(value = "id") long id,  @Valid @RequestBody Categories categories) {
		
		return categoriesCrud.UpdateCategories(id, categories);
	}

}