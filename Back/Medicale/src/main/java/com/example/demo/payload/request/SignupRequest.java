package com.example.demo.payload.request;

import javax.validation.constraints.Email;

public class SignupRequest {

	private  String Nom;

	private String Prenom;

	private String DateNaissance;

	private String Tel;
	@Email
	private String Mail;

	private String Mdp;
	
	private String Role;
	private String state;
	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}

	
}
