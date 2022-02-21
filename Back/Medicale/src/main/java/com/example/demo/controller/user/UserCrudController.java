package com.example.demo.controller.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.services.user.UserCrudImplement;
import com.example.demo.model.users.User;

@RestController
@RequestMapping("/user")
public class UserCrudController implements UserCrudControllerInterface {
@Autowired
UserCrudImplement userCrud;


@Override
@GetMapping()
public List<User> searchAllUser() {
	// TODO Auto-generated method stub
	 	return userCrud.findAllUser();
}
@Override
@GetMapping("/{id}")
public Optional<User> searchUserById( @PathVariable(value = "id") int id) {
	// TODO Auto-generated method stub
	return userCrud.findUserById(id);
}
@Override
@PostMapping()
public User AddingUser(@RequestBody @Valid User user) {
	// TODO Auto-generated method stub
	return userCrud.AddUser(user);
}
@Override
@DeleteMapping("/{id}")
public void DeletingUser( @PathVariable(value = "id") int userid) {
	// TODO Auto-generated method stub
	userCrud.DeleteUser(userid);
}
@Override
@GetMapping("/{state}")
public User blockingUser(User user,  @PathVariable(value = "state") String state) {
	// TODO Auto-generated method stub
	return userCrud.blockUser(user, state);
}





}
