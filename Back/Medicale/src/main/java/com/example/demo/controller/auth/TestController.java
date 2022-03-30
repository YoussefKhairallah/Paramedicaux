package com.example.demo.controller.auth;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }
  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('LIVREURR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }
  @GetMapping("/liv")
  @PreAuthorize("hasRole('LIVREUR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }
  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}