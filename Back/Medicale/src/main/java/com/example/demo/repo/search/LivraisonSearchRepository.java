package com.example.demo.repo.search;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.vente.Livraison;

public interface LivraisonSearchRepository extends JpaRepository<Livraison, Integer> {
	Optional<Livraison> findByDateSortie(Date DateSortie);
	Optional<Livraison> findByAdrClient(String AdresseClient);
	Optional<Livraison>	findByFraisLiv(float FraisLiv);
	Optional<Livraison> findByNbreJour(String NbreJour);
	Optional<Livraison> findByAdrSociete(String AdresseSociete);
	Optional<Livraison>	findByEtat(String Etat);
}
