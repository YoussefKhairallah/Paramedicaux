package com.example.demo.payload.request;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SignupRequest {
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
	private Date DateNaissance;
	@Column(length = 8)
	@NotBlank
	@NotNull
	private String Tel;
	@NotBlank
	@Column(length = 255)
	@Email
	@NotNull
	private String Mail;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private String Mdp;
	
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
	public Date getDateNaissance() {
		return DateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
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
