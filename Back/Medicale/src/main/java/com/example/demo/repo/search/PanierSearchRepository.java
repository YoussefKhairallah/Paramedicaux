package com.example.demo.repo.search;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.vente.Panier;

@Repository
public interface PanierSearchRepository extends JpaRepository<Panier, Integer> {
	@Query(value = "SELECT ModePaiement FROM Panier")
	Optional<Panier> SearchByModePaiement(String ModePaiement);
	@Query(value = "SELECT DateCreation FROM Panier")
	Optional<Panier> SearchByDateCreation(Date DateCreation);
	@Query(value = "SELECT TotalePrix FROM Panier")
	Optional<Panier> SearchByPrix(double TotalePrix);
}
