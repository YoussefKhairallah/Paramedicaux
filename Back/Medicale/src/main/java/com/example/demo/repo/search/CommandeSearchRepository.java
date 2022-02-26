package com.example.demo.repo.search;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.vente.Commande;

@Repository
public interface CommandeSearchRepository extends JpaRepository<Commande, Integer> {
	@Query(value = "SELECT Adresse FROM Commande")
	Optional<Commande> SearchByAdresse(String Adresse);
	@Query(value = "SELECT PrixTotale FROM Commande")
	Optional<Commande> SearchByPrix(String PrixTotale);
	@Query(value = "SELECT Qte FROM Commande")
	Optional<Commande> SearchByQuantite(int Qte);
	@Query(value = "SELECT Etat FROM Commande")
	Optional<Commande> SearchByEtat(String Etat);
	@Query(value = "SELECT Date FROM Commande")
	Optional<Commande> SearchByDate(LocalDateTime Date);
}
