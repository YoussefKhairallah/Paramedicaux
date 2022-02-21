package com.example.demo.controller.vente;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.services.vente.CategoriesCrudImplement;
import com.example.demo.model.vente.Categories;

@RestController
@RequestMapping("/categories")
public class CategoriesCrudController implements CategoriesCrudControllerInterface {
	@Autowired
	CategoriesCrudImplement categoriesCrud;
	
	@Override
	public List<Categories> searchAllCategories() {
		// TODO Auto-generated method stub
		return categoriesCrud.findAllCategories();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<Categories> searchCategoriesById(@PathVariable(value = "id") int id) {
		// TODO Auto-generated method stub
		return categoriesCrud.findCategoriesById(id);
	}

	@Override
	@PostMapping()
	public Categories AddingCategories(@RequestBody @Valid Categories categories) {
		// TODO Auto-generated method stub
		return categoriesCrud.AddCategories(categories);
	}

	@Override
	@DeleteMapping("/{id}")
	public void DeletingCategories(@PathVariable(value = "id") int categoriesid) {
		// TODO Auto-generated method stub
		categoriesCrud.DeleteCategories(categoriesid);
	}

}
