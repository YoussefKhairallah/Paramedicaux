package com.example.demo.Security.service;

public class JwtResponse {
	private int id;
	private String token;
    private String Mail;
    private String Mdp;
    private String type="bearer";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public JwtResponse(String token, int id, String mail, String mdp) {
		super();
		this.id = id;
		this.token = token;
		Mail = mail;
		Mdp = mdp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


}
