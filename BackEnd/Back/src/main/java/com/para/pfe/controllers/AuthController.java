package com.para.pfe.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.para.pfe.models.ERole;
import com.para.pfe.models.Role;
import com.para.pfe.models.User;
import com.para.pfe.payload.request.LoginRequest;
import com.para.pfe.payload.request.SignupRequest;
import com.para.pfe.payload.response.JwtResponse;
import com.para.pfe.payload.response.MessageResponse;
import com.para.pfe.repository.RoleRepository;
import com.para.pfe.repository.UserRepository;
import com.para.pfe.security.jwt.JwtUtils;
import com.para.pfe.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();  
    System.out.println(userDetails);
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    /*if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }
*/
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    

    //Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
    String strRoles = signUpRequest.getRole();
    System.out.println("role"+strRoles);
    User user = new User(signUpRequest.getNom(),
    					signUpRequest.getPrenom(),
    					signUpRequest.getDateNaissance(),
    					signUpRequest.getTel(),
    					signUpRequest.getAdresse(),
    					signUpRequest.getCodePostal(),
    					signUpRequest.getVille(),
    					signUpRequest.getEmail(),
    					encoder.encode(signUpRequest.getPassword()),
    					signUpRequest.getState(),
    					signUpRequest.getRole(), strRoles, strRoles
    					);
    /*
    if (signUpRequest.getRole() == null) {
        Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(clientRole);
      } else {
    	  Set<String> strRoles = signUpRequest.getRole();

      strRoles.forEach(role -> {
    	  */
        switch (strRoles) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "livreur":
            Role livreurRole = roleRepository.findByName(ERole.ROLE_LIVREUR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(livreurRole);

            break;
        case "client":
            Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(clientRole);
        }
     // });
    
     // }
    user.setRoles(roles);
    System.out.println(user);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
