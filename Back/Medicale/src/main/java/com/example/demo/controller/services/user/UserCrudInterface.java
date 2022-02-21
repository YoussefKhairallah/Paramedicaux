package com.example.demo.controller.services.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.users.User;

public interface UserCrudInterface {
	List<User> findAllUser();
	 Optional<User> findUserById(int id);
	 User AddUser(User user);
void DeleteUser(int userid);
User blockUser(User user,String state);


}
