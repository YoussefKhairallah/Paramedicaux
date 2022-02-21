package com.example.demo.repo.search;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.users.Avis;

public interface AvisSearchRepository extends JpaRepository<Avis, Integer> {
	Optional<Avis> findByDesc(String desc);
	Optional<Avis> findByDate(LocalDateTime Date);
}
