package com.example.demo.repo.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.vente.Commande;

public interface CommandeCrudRepository extends CrudRepository<Commande, Integer> {

}
