package com.bezkoder.springjwt.controllers.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.controllers.services.UserCrudImplement;
import com.bezkoder.springjwt.models.User;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class UserCrudController implements UserCrudControllerInterface {
	
	@Autowired
	UserCrudImplement userCrud;

	@Override
	@GetMapping("/users")
	public List<User> findAllUser() {
		return userCrud.findAllUser();
	}

	@Override
	@GetMapping("/findbyid/{id}")
	public Optional<User> findUserById(@PathVariable(value = "id") long id) {
		return userCrud.findUserById(id);
	}

	@Override
	@PostMapping("/adduser")
	public User AddingUser(@RequestBody @Valid User user) {
		return userCrud.AddUser(user);
	}

	@Override
	@DeleteMapping("/deleteuser/{id}")
	public void DeletingUser(@PathVariable(value = "id") long userid) {
		userCrud.DeleteUser(userid);

	}
/*
	@Override
	@PutMapping("/blockuser/{id}")
	public User blockingUser(User user, long id) {
		return userCrud.blockUser(user, id);
	}
	*/

	@Override
	@PutMapping("updateUser/{id}")
	public User UpdatedUser(User user, long id) {
	
		return userCrud.UpdateUser(user, id);
	}

}
