package com.example.demo.repo.search;

import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.users.Avis;


@Repository
public interface AvisSearchRepository extends JpaRepository<Avis, Integer> {
	@Query(value = "SELECT Description FROM Avis")
	Optional<Avis> SearchByDescription(String description);
	@Query(value = "SELECT Date FROM Avis")
	Optional<Avis> SearchByDate(Date Date);
}
