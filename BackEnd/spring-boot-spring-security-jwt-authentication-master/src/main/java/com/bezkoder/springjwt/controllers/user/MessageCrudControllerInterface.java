package com.bezkoder.springjwt.controllers.user;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Message;


public interface MessageCrudControllerInterface {
	List<Message> findAllMessage();
	Optional<Message> findMessageById(long id);
	Message AddingMessage(Message message);
	Message UpdatedMessage(Message message, long id);
	void DeletingMessage(long messageid);
}
