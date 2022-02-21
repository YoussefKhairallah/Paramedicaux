package com.example.demo.repo.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.users.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {

}
