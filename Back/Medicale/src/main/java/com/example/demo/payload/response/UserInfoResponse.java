package com.example.demo.payload.response;

import java.sql.Date;



public class UserInfoResponse {
	private int id;

	private  String Nom;

	private String Prenom;

	private Date DateNaissance;

	private String Tel;

	private String Mail;

	private String Mdp;

	public String Role;

	private String state;

	
	public UserInfoResponse(int id, String nom, String prenom, Date dateNaissance, String tel, String mail, String mdp,
			String role, String state) {

		this.id = id;
		Nom = nom;
		Prenom = prenom;
		DateNaissance = dateNaissance;
		Tel = tel;
		Mail = mail;
		Mdp = mdp;
		Role = role;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
