package com.example.demo.repo.search;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.vente.Livraison;

@Repository
public interface LivraisonSearchRepository extends JpaRepository<Livraison, Integer> {
	@Query(value = "SELECT DateSortie FROM Livraison")
	Optional<Livraison> findByDateSortie(Date DateSortie);
	@Query(value = "SELECT AdresseClient FROM Livraison")
	Optional<Livraison> findByAdresseClient(String AdresseClient);
	@Query(value = "SELECT FraisLiv FROM Livraison")
	Optional<Livraison>	findByFraisLiv(float FraisLiv);
	@Query(value = "SELECT NbreJour FROM Livraison")
	Optional<Livraison> findByJour(int NbreJour);
	@Query(value = "SELECT AdresseSociete FROM Livraison")
	Optional<Livraison> findByAdresseSociete(String AdresseSociete);
	@Query(value = "SELECT Etat FROM Livraison")
	Optional<Livraison>	findByEtat(String Etat);
}
