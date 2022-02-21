package com.example.demo.repo.search;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.users.User;

public interface UserSearchRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByNom(String Nom);
	Optional<User> findByPrenom(String Prenom);
	Optional<User> findBymail(String Mail);
	Optional<User> findByMotPasse(String Mdp);
	Optional<User> findByAge(int Age);
	Optional<User> findByTel(String Tel);
	Optional<User> findByRole(String Role);
	Optional<User> findByMailMotPasse(String Mail, String Mdp);
}
