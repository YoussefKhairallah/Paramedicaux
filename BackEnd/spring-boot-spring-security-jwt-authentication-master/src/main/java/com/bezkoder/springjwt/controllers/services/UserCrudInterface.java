package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.User;


public interface UserCrudInterface {
	List<User> findAllUser();
	 Optional<User> findUserById(long id);
	 User AddUser(User user);
	 User UpdateUser(User user, long id);
	 void DeleteUser(long userid);
	 ///User blockUser(User user, long id);
}
