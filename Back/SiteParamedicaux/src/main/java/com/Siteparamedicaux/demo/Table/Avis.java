package com.Siteparamedicaux.demo.Table;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Desc;
	private LocalDateTime Date;
	
	public Avis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Avis(String desc, LocalDateTime date) {
		super();
		Desc = desc;
		Date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public LocalDateTime getDate() {
		return Date;
	}
	public void setDate(LocalDateTime date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + ", Desc=" + Desc + ", Date=" + Date + "]";
	}
	
}
