package com.example.demo.Security.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.users.User;
import com.example.demo.repo.search.UserSearchRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserSearchRepository userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String Nom) throws UsernameNotFoundException {
	  User user = userRepository.findByNom(Nom)
	      .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + Nom));
	  return User.build(user);
	}

}
