package com.example.demo.model.users;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.example.demo.model.vente.Produit;


@Entity
public class Avis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 255)
	@NotBlank
	private String desc;
@NotBlank
	private LocalDateTime Date;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Produit produit;
	
	
	public Avis() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Avis(@NotBlank String desc, @NotBlank LocalDateTime date) {
		super();
		this.desc = desc;
		Date = date;
	
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	@Override
	public String toString() {
		return "Avis [id=" + id + ", desc=" + desc + ", Date=" + Date + "]";
	}
	
	
}
