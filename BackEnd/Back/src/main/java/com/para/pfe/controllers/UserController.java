package com.para.pfe.controllers;


import com.para.pfe.exception.ResourceNotFoundException;
import com.para.pfe.models.User;
import com.para.pfe.repository.UserRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200"}, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class UserController {
     @Autowired
    private UserRepository UserRepository;
        
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return  (List<User>) UserRepository.findAll();
        //return (List<User>) UserRepository.findAll();
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long username)
        throws ResourceNotFoundException {
        User users = UserRepository.findById(username)
          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + username));
        return ResponseEntity.ok().body(users);
    }
    
    @GetMapping("/usersByRole/{userRole}")    
    public List<User> getUser(@PathVariable String userRole){
    	System.out.println(userRole);
        return UserRepository.findByRolesIn(Arrays.asList(userRole));
    }
    
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User users) {
        return UserRepository.save(users);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") String username,
         @Valid @RequestBody User usersDetails) throws ResourceNotFoundException {
        User users = UserRepository.findByUsername(username)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + username));

        users.setEmail(usersDetails.getEmail());
        users.setNom(usersDetails.getNom());
        users.setPassword(usersDetails.getPassword());
        users.setRoles(usersDetails.getRoles());
        final User updatedUser = UserRepository.save(users);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") String email)
         throws ResourceNotFoundException {
        User users = UserRepository.findByUsername(email)
       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + email));

        UserRepository.delete(users);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
