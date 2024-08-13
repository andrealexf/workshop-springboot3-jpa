package com.projetowebservices.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetowebservices.course.entities.User;
import com.projetowebservices.course.services.UserService;

@RestController //é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/users") //nome 
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping //responde ao Get
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //requisição aceita um id pelo url
	public ResponseEntity<User> findById(@PathVariable Long id){ //path variable por causa do parâmetro da url
		
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
		