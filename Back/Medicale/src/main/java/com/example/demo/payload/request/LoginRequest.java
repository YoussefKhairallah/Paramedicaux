package com.example.demo.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginRequest {
	@NotBlank
	@NotNull
	private String Mail;
	@NotBlank
	@NotNull
	private String Mdp;

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

