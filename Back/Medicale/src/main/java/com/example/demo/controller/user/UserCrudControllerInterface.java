package com.example.demo.controller.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.users.User;

public interface UserCrudControllerInterface {
	List<User> searchAllUser();
	 Optional<User> searchUserById(int id);
	 User AddingUser(User user);
void DeletingUser(int userid);
User blockingUser(User user,String state);
}
