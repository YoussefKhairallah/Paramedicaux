package com.example.demo.repo.search;

import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.users.User;

@Repository
public interface UserSearchRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT Nom FROM User")
	Optional<User> SearchByNom(String Nom);
	@Query(value = "SELECT Prenom FROM User")
	Optional<User> SearchByPrenom(String Prenom);
	@Query(value = "SELECT Mail FROM User")
	Optional<User> SearchBymail(String Mail);
	@Query(value = "SELECT Mdp FROM User")
	Optional<User> SearchByMotPasse(String Mdp);
	@Query(value = "SELECT DateNaissance FROM User")
	Optional<User> SearchByDateNaissance(Date DateNaissance);
	@Query(value = "SELECT Tel FROM User")
	Optional<User> SearchByTel(String Tel);
	@Query(value = "SELECT Role FROM User")
	Optional<User> SearchByRole(String Role);
	@Query(value = "SELECT Mail, Mdp FROM User")
	Optional<User> SearchByMailMotPasse(String Mail, String Mdp);
}