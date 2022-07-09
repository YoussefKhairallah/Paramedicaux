package com.para.pfe.payload.request;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class SignupRequest {
	
	@Column(length = 50)
	
	
	private  String Nom;
	
	@Column(length = 50)
	
	
	private String Prenom;
	
	
	
	private String DateNaissance;
	
	@Column(length = 8)
	
	
	private String Tel;
	
	
	private String adresse;
	
	
	private String ville;
	
	
	private String codePostal;
	
	@Size(max = 50)
	@Email
	private String email;

	
	@Size(min = 6, max = 40)
	private String password;
	
	
	//
	private String state;
	
	private String role;

	
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
	
	  public String getRole() {
	    return this.role;
	  }
	
	  public void setRole(String role) {
	    this.role = role;
	  }

}
