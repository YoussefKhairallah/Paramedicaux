package com.Siteparamedicaux.demo.Table;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Desc;
	private LocalDateTime Date;
	private String Type;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Message(String desc, LocalDateTime date, String type) {
		super();
		Desc = desc;
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
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", Desc=" + Desc + ", Date=" + Date + ", Type=" + Type + "]";
	}
	
}
