package com.Siteparamedicaux.demo.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private  String Nom;
	private String Prenom;
	private String Mail;
	private String Mdp;
	private String Tel;
	private String Roll;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String nom, String prenom, String mail, String mdp, String tel, String roll) {
		super();
		Nom = nom;
		Prenom = prenom;
		Mail = mail;
		Mdp = mdp;
		Tel = tel;
		Roll = roll;
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
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getRoll() {
		return Roll;
	}
	public void setRoll(String roll) {
		Roll = roll;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Mail=" + Mail + ", Mdp=" + Mdp + ", Tel="
				+ Tel + ", Roll=" + Roll + "]";
	}
	
}
