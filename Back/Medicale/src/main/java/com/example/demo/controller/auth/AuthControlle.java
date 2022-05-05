package com.example.demo.controller.auth;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Security.JWT.JwtUtils;
import com.example.demo.Security.service.JwtResponse;
import com.example.demo.Security.service.UserDetailsImpl;
import com.example.demo.model.users.User;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.MessageResponse;

import com.example.demo.repo.search.UserSearchRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthControlle {
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  UserSearchRepository userRepository;
  @Autowired
  PasswordEncoder encoder;
  @Autowired
  JwtUtils jwtUtils;
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getMail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		String jwt = jwtUtils.generateJwtToken(authentication);
		System.out.println(jwt);

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getMail(), 
												 userDetails.getPassword()
												 ));
		
	}
 
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

		// Create new user's account
		User user = new User(	signUpRequest.getNom(),
				                signUpRequest.getPrenom(),
				                signUpRequest.getDateNaissance(),
				                signUpRequest.getTel(),
				                signUpRequest.getMail(),
				                encoder.encode(signUpRequest.getMdp()), 
				                signUpRequest.getRole(),
				                signUpRequest.getState()
				                );
  
    		System.out.println(user);
    userRepository.save(user);
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
  }


