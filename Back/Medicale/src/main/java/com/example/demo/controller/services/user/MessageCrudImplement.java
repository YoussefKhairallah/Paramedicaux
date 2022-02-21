package com.example.demo.controller.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.users.Message;
import com.example.demo.repo.crud.MessageCrudRepository;

@Service
public class MessageCrudImplement implements MessageCrudInterface {

	@Autowired
	MessageCrudRepository msgapi;
	
	@Override
	public List<Message> findAllMessage() {
		// TODO Auto-generated method stub
		return (List<Message>) msgapi.findAll();
	}

	@Override
	public Optional<Message> findMessageById(int id) {
		// TODO Auto-generated method stub
		return msgapi.findById(id);
	}

	@Override
	public Message AddMessage(Message message) {
		// TODO Auto-generated method stub
		return msgapi.save(message);
	}
	@Override
	public void DeleteMessage(int messageid) {
		// TODO Auto-generated method stub
		msgapi.deleteById(messageid);
	}

}
