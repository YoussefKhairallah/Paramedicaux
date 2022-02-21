package com.example.demo.controller.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.users.Message;

public interface MessageCrudControllerInterface {
	List<Message> searchAllMessage();
	Optional<Message> searchMessageById(int id);
	Message AddingMessage(Message message);
	void DeletingMessage(int messageid);
}
