package com.example.demo.repo.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.vente.Produit;

public interface ProduitCrudRepository extends CrudRepository<Produit, Integer> {

}
