package com.example.demo.model.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
	@Column(length = 255)
	@Email
	@NotNull
	private String Mail;
	@Column(length = 255)
	@NotBlank
	@NotNull
	private String Mdp;
	@Column(length = 20)
	//@NotBlank
	public String Role;
	@NotBlank
	//@NotNull
	private String state;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(@NotBlank String nom, @NotBlank String prenom, @NotBlank String dateNaissance, @NotBlank String tel,
			@NotBlank @Email String mail, @NotBlank String mdp, String role, String state) {
		super();
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

	@Override
	public String toString() {
		return "User [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", DateNaissance=" + DateNaissance + ", Tel="
				+ Tel + ", Mail=" + Mail + ", Mdp=" + Mdp + ", Role=" + Role + ", state=" + state + "]";
	}

	public void setuserCode(String string) {
		// TODO Auto-generated method stub
		
	}
	public static UserDetails build(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
