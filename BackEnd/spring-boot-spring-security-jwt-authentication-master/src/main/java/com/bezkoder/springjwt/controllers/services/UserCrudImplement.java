package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;

@Service
public class UserCrudImplement implements UserCrudInterface {
	@Autowired
	UserRepository userRepo;
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) userRepo.findAll();
	}

	@Override
	public Optional<User> findUserById(long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public User AddUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public void DeleteUser(long userid) {
		userRepo.deleteById(userid);

	}
	/*
	@Override
	public User blockUser(User user, Long id) {
		user.setState("block");
		return userRepo.save(user);
	}
	*/

	@Override
	public User UpdateUser(User user, long id) {

		return userRepo.save(user);
	}

}
