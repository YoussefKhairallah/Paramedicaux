package com.para.pfe.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.para.pfe.exception.ResourceNotFoundException;
import com.para.pfe.models.Message;
import com.para.pfe.repository.MessageRepository;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200"}, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class MessageController {
	  @Autowired
	    private MessageRepository MessageRepository;
	        
	    @GetMapping("/message")
	    public List<Message> getAllMessages() {
	        return  (List<Message>) MessageRepository.findAll();
	    }


	    @GetMapping("/message/{id}")
	    public ResponseEntity<Message> getMessageById(@PathVariable(value = "id") Long id)
	        throws ResourceNotFoundException {
	        Message message = MessageRepository.findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("Message not found for this id :: " + id));
	        return ResponseEntity.ok().body(message);
	    }
	    
	    @PostMapping("/message")
	    public Message createMessage(@Valid @RequestBody Message message) {
	        return MessageRepository.save(message);
	    }

	    @PutMapping("/message/{id}")
	    public ResponseEntity<Message> updateMessage(@PathVariable(value = "id") Long id,
	         @Valid @RequestBody Message messageDetails) throws ResourceNotFoundException {
	        Message message = MessageRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Message not found for this id :: " + id));
	        
	        
	        final Message updatedMessage = MessageRepository.save(message);
	        return ResponseEntity.ok(updatedMessage);
	    }

	    @DeleteMapping("/message/{id}")
	    public Map<String, Boolean> deleteMessage(@PathVariable(value = "id") Long id)
	         throws ResourceNotFoundException {
	        Message message = MessageRepository.findById(id)
	       .orElseThrow(() -> new ResourceNotFoundException("Message not found for this id :: " + id));

	        MessageRepository.delete(message);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
