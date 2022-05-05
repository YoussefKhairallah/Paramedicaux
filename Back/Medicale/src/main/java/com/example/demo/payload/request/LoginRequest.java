package com.example.demo.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	private String Mail;
	@NotBlank
	private String Password;

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}

