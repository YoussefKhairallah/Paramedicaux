package com.example.demo.controller.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.services.user.MessageCrudImplement;
import com.example.demo.model.users.Message;

@RestController
@RequestMapping("/message")
public class MessageCrudController implements MessageCrudControllerInterface {
	@Autowired
	MessageCrudImplement messageCrud;

	@Override
	@GetMapping()
	public List<Message> searchAllMessage() {
		// TODO Auto-generated method stub
		return messageCrud.findAllMessage();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<Message> searchMessageById(@PathVariable(value = "id") int id) {
		// TODO Auto-generated method stub
		return messageCrud.findMessageById(id);
	}

	@Override
	@PostMapping("/addMsg")
	public Message AddingMessage(@RequestBody @Valid Message message) {
		// TODO Auto-generated method stub
		return messageCrud.AddMessage(message);
	}

	@Override
	@DeleteMapping("/{id}")
	public void DeletingMessage(@PathVariable(value = "id") int messageid) {
		// TODO Auto-generated method stub
		messageCrud.DeleteMessage(messageid);
	}

}
