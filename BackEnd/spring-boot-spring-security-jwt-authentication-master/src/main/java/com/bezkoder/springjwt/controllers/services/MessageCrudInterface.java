package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Message;

public interface MessageCrudInterface {
	List<Message> findAllMessage();
	Optional<Message> findMessageById(long id);
	Message AddMessage(Message message);
	Message UpdateMessage(Message message, long id);
	void DeleteMessage(long messageid);
}
