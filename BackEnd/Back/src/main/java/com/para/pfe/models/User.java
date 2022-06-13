package com.para.pfe.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String image;
  @Column(length = 50)


	private  String username;
	@Column(length = 50)

	private  String Nom;
	@Column(length = 50)


	private String Prenom;


	private String DateNaissance;
	@Column(length = 8)


	private String Tel;

	@Size(max = 50)
	//@Email
	private String email;

	@Size(max = 120)
	private String password;

	private String adresse;

	private String ville;

	private String codePostal;

	private String pays;

	//@NotNull
	private String state;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username,String nom, String prenom, String dateNaissance, String tel, String adresse, String codePostal, String ville, String pays, String email, String password, String image, String state) {
	
    this.username = username;
	this.Nom = nom;
	this.Prenom = prenom;
	this.DateNaissance = dateNaissance;
	this.Tel = tel;
	this.adresse = adresse;
    this.codePostal = codePostal;
    this.pays = pays;
    this.ville = ville;
    this.email = email;
    this.password = password;
    this.image = image;
    this.state = state;
    
  }

  public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getVille() {
	return ville;
}

public void setVille(String ville) {
	this.ville = ville;
}

public String getCodePostal() {
	return codePostal;
}

public void setCodePostal(String codePostal) {
	this.codePostal = codePostal;
}

public String getPays() {
	return pays;
}

public void setPays(String pays) {
	this.pays = pays;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public String getNom() {
	return Nom;
}

	public void setNom(String nom) {
		Nom = nom;
	}
	
	public String getPrenom() {
		return Prenom;
	}
	
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	public String getDateNaissance() {
		return DateNaissance;
	}
	
	public void setDateNaissance(String dateNaissance) {
		DateNaissance = dateNaissance;
	}
	
	public String getTel() {
		return Tel;
	}
	
	public void setTel(String tel) {
		Tel = tel;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
