package com.example.demo.model.users;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(length = 255)
	@NotBlank
	private String Description;
	@NotNull
	@NotBlank
	private Date Date;
	@Column(length = 50)
	@NotBlank
	@NotNull
	private String Type;
	
	@ManyToOne
	private User admin;
	
	@ManyToOne
	private User client;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Message(@NotBlank String description, Date date, @NotBlank String type) {
		super();
		Description = description;
		Date = date;
		Type = type;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", Description=" + Description + ", Date=" + Date + ", Type=" + Type +
				"]";
	}

	

}
