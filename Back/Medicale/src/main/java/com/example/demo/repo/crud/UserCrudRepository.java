package com.example.demo.repo.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.users.User;

public interface UserCrudRepository extends CrudRepository<User, Integer> {

}
