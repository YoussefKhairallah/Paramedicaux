package com.example.demo.model.users;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 255)
	@NotBlank
	private String desc;
	@Column(nullable = false)
	private LocalDateTime Date;
	@Column(length = 50)
	@NotBlank
	private String Type;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<User> user;
	
	@OneToMany
	private Set<User> client;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(@NotBlank String desc, LocalDateTime date, @NotBlank String type) {
		super();
		this.desc = desc;
		Date = date;
		Type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDateTime getDate() {
		return Date;
	}

	public void setDate(LocalDateTime date) {
		Date = date;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Set<User> getClient() {
		return client;
	}

	public void setClient(Set<User> client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", desc=" + desc + ", Date=" + Date + ", Type=" + Type + "]";
	}
	

}
