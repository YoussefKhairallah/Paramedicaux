package com.bezkoder.springjwt.controllers.user;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.User;


public interface UserCrudControllerInterface {
	List<User> findAllUser();
	 Optional<User> findUserById(long id);
	 User AddingUser(User user);
	 User UpdatedUser(User user, long id);
void DeletingUser(long userid);
//User blockingUser(User user,long id);
}
