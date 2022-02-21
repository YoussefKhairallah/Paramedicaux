package com.example.demo.repo.search;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.vente.Commande;

public interface CommandeSearchRepository extends JpaRepository<Commande, Integer> {
	Optional<Commande> findbyAdresse (String Adresse);
	Optional<Commande> findByPrix(String PrixTotale);
	Optional<Commande> findByQuantite(int Qte);
	Optional<Commande> findByEtat(String Etat);
	Optional<Commande> findByDate(LocalDateTime Date);
}
