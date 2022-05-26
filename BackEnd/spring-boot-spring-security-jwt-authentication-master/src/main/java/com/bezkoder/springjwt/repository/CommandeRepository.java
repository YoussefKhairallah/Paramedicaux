package com.bezkoder.springjwt.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.bezkoder.springjwt.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
