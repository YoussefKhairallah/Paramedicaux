package com.para.pfe.payload.request;

import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class SignupRequest {
	
	@NotEmpty(message = "Please enter username")
	@Size(min = 3, max = 20)
	private String username;
	
  private String image;
	@Column(length = 50)
	@NotBlank
	@NotNull
	private  String Nom;
	
	@Column(length = 50)
	@NotBlank
	@NotNull
	private String Prenom;
	
	@NotBlank
	@NotNull
	private String DateNaissance;
	
	@Column(length = 8)
	@NotBlank
	@NotNull
	private String Tel;
	
	@NotBlank
	private String adresse;
	
	@NotBlank
	private String ville;
	
	@NotBlank
	private String codePostal;
	
	@NotBlank
	private String pays;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;
	
	@NotBlank
	//@NotNull
	private String state;
	
	private Set<String> role;

	
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
	
	  public Set<String> getRole() {
	    return this.role;
	  }
	
	  public void setRole(Set<String> role) {
	    this.role = role;
	  }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUsername() {
		return username;
	  }
	
	  public void setUsername(String username) {
		this.username = username;
	  }
}