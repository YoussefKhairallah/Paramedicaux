package com.example.demo.repo.search;


import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.users.Message;

@Repository
public interface MessageSearchRepository extends JpaRepository<Message, Integer> {
	@Query(value = "SELECT Description FROM Message")
	Optional<Message> findByDescription(String Description);
	@Query(value = "SELECT Date FROM Message")
	Optional<Message> findBydate(Date Date);
	@Query(value = "SELECT Type FROM Message")
	Optional<Message> findByType(String Type);
}
