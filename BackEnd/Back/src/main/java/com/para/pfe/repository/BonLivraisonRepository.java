package com.para.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.para.pfe.models.Message;

public interface BonLivraisonRepository extends JpaRepository<Message,Long> {

}
