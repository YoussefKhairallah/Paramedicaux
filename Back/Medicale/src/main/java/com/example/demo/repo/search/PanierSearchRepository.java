package com.example.demo.repo.search;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.vente.Panier;

public interface PanierSearchRepository extends JpaRepository<Panier, Integer> {
	Optional<Panier> findByModePaiement(String ModePaiement);
	Optional<Panier> findByDateCreation(LocalDateTime DateCreation);
	Optional<Panier> findByPrix(double TotalePrix);
}
