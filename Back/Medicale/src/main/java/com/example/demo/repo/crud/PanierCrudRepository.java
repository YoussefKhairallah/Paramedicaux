package com.example.demo.repo.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.vente.Panier;

public interface PanierCrudRepository extends CrudRepository<Panier, Integer> {

}
