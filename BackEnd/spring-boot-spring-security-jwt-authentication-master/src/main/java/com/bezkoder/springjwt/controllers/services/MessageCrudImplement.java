package com.bezkoder.springjwt.controllers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Message;
import com.bezkoder.springjwt.repository.MessageRepository;

@Service
public class MessageCrudImplement implements MessageCrudInterface {
	@Autowired
	MessageRepository msgRepo;
	@Override
	public List<Message> findAllMessage() {
		// TODO Auto-generated method stub
		return (List<Message>) msgRepo.findAll();
	}

	@Override
	public Optional<Message> findMessageById(long id) {
		// TODO Auto-generated method stub
		return msgRepo.findById(id);
	}

	@Override
	public Message AddMessage(Message message) {
		// TODO Auto-generated method stub
		return msgRepo.save(message);
	}

	@Override
	public void DeleteMessage(long messageid) {
		// TODO Auto-generated method stub
		msgRepo.deleteById(messageid);
	}

	@Override
	public Message UpdateMessage(Message message, long id) {
		// TODO Auto-generated method stub
		return msgRepo.save(message);
	}

}
