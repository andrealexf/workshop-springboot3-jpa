package com.projetowebservices.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetowebservices.course.entities.User;

@RestController //é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/users") //nome 
public class UserResource {

	@GetMapping //responde ao Get
	public ResponseEntity<User> findAll(){
		
		User u = new User(1L, "Maria", "maria@gmail.com","999999999","12345"); //1L por causa de long
		return ResponseEntity.ok().body(u);
	}
}
