package com.example.demo.repo.search;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.users.Message;

public interface MessageSearchRepository extends JpaRepository<Message, Integer> {
	Optional<Message> findByDesc(String desc);
	Optional<Message> findByDate(LocalDateTime Date);
	Optional<Message> findByType(String Type);
}
