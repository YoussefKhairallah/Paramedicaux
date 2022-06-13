package com.para.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.para.pfe.models.Commande;

public interface CommandeRepository  extends JpaRepository<Commande,Long> {

}
