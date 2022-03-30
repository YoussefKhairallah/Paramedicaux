package com.example.demo.controller.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.users.User;
import com.example.demo.repo.crud.UserCrudRepository;

@Service
public class UserCrudImplement implements UserCrudInterface {

	@Autowired
	UserCrudRepository userapi;
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) userapi.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		// TODO Auto-generated method stub
		return userapi.findById(id);
	}

	@Override
	public  User AddUser(User user) {
		// TODO Auto-generated method stub
		return userapi.save(user);
	}

	@Override
	public void DeleteUser(int userid) {
		// TODO Auto-generated method stub
		userapi.deleteById(userid);

	}

	@Override
	public User blockUser(User user, String state) {
		// TODO Auto-generated method stub
		user.setState(state);
		return userapi.save(user);
	}

	public User findBymail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

}
