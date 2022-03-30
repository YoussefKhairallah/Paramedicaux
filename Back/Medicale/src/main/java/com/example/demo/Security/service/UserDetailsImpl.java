package com.example.demo.Security.service;

import java.util.Collection;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private int id;
	  private String Nom;
	  private String Mail;
	  @JsonIgnore
	  private String Mdp;
	  
	  private Collection<? extends GrantedAuthority> authorities;
	  public UserDetailsImpl(int id, String nom, String mail, String password,
	      Collection<? extends GrantedAuthority> authorities) {
	    this.id = id;
	    this.Nom = nom;
	    this.Mail = mail;
	    this.Mdp = password;
	    this.authorities = authorities;
	  }
		  @Override
		  public Collection<? extends GrantedAuthority> getAuthorities() {
		    return authorities;
		  }
		  public int getId() {
		    return id;
		  }
		  public String getEmail() {
		    return Mail;
		  }
		  @Override
		  public String getPassword() {
		    return Mdp;
		  }
		  @Override
		  public String getUsername() {
		    return Nom;
		  }
		  @Override
		  public boolean isAccountNonExpired() {
		    return true;
		  }
		  @Override
		  public boolean isAccountNonLocked() {
		    return true;
		  }
		  @Override
		  public boolean isCredentialsNonExpired() {
		    return true;
		  }
		  @Override
		  public boolean isEnabled() {
		    return true;
		  }
		  @Override
		  public boolean equals(Object o) {
		    if (this == o)
		      return true;
		    if (o == null || getClass() != o.getClass())
		      return false;
		    UserDetailsImpl user = (UserDetailsImpl) o;
		    return Objects.equals(id, user.id);
		  }
}
