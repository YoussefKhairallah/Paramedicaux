package com.bezkoder.springjwt.controllers.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.controllers.services.MessageCrudImplement;
import com.bezkoder.springjwt.models.Message;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/message")
public class MessageCrudController implements MessageCrudControllerInterface {
	@Autowired
	MessageCrudImplement messageCrud;
	
	@Override
	@GetMapping("/findMessage")
	public List<Message> findAllMessage() {

		return messageCrud.findAllMessage();
	}

	@Override
	@GetMapping("/findMessageById/{id}")
	public Optional<Message> findMessageById(@PathVariable(value = "id") long id) {

		return messageCrud.findMessageById(id);
	}

	@Override
	@PostMapping("/addMsg")
	public Message AddingMessage(@RequestBody @Valid Message message) {

		return messageCrud.AddMessage(message);
	}

	@Override
	@DeleteMapping("/deleteMsg/{id}")
	public void DeletingMessage(@PathVariable(value = "id") long messageid) {

		messageCrud.DeleteMessage(messageid);
	}

	@Override
	@PutMapping("updateMessage/{id}")
	public Message UpdatedMessage(Message message, long id) {
		// TODO Auto-generated method stub
		return messageCrud.UpdateMessage(message, id);
	}

}
