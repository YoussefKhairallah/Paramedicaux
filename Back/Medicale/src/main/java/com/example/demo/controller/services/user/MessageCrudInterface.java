package com.example.demo.controller.services.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.users.Message;

public interface MessageCrudInterface {
	List<Message> findAllMessage();
	Optional<Message> findMessageById(int id);
	Message AddMessage(Message message);
	void DeleteMessage(int messageid);
}
