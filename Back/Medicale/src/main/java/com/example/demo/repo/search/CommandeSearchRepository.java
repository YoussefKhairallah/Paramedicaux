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
	Optional<Commande> findByAdresse(String Adresse);
	@Query(value = "SELECT PrixTotale FROM Commande")
	Optional<Commande> findByPrix(String PrixTotale);
	@Query(value = "SELECT Qte FROM Commande")
	Optional<Commande> findByQuantite(int Qte);
	@Query(value = "SELECT Etat FROM Commande")
	Optional<Commande> findByEtat(String Etat);
	@Query(value = "SELECT Date FROM Commande")
	Optional<Commande> findByDate(LocalDateTime Date);
}
