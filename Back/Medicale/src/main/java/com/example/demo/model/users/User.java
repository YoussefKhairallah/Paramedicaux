package com.example.demo.model.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	@NotBlank
	private  String Nom;
	@Column(length = 50)
	@NotBlank
	private String Prenom;
	@Column(length = 255, nullable = false)
	@Email
	private String Mail;
	@Column(length = 255)
	@NotBlank
	private String Mdp;
	@NotBlank
	private int Age;
	@Column(length = 8)
	@NotBlank
	private String Tel;
	@Column(length = 20)
	@NotBlank
	private String Role;
	@NotBlank
	private String state;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String nom, String prenom, String mail, String mdp, int age, String tel, String role) {
		super();
		Nom = nom;
		Prenom = prenom;
		Mail = mail;
		Mdp = mdp;
		Age = age;
		Tel = tel;
		Role = role;
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
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Mail=" + Mail + ", Mdp=" + Mdp + ", Age="
				+ Age + ", Tel=" + Tel + ", Role=" + Role + "]";
	}

	
	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public void setuserCode(String string) {
		// TODO Auto-generated method stub
		
	}

}
