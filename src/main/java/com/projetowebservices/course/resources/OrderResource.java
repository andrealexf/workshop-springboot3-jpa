package com.projetowebservices.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetowebservices.course.entities.Order;
import com.projetowebservices.course.services.OrderService;

@RestController //é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/orders") //nome 
public class OrderResource {
	
	@Autowired
	private OrderService service;

	@GetMapping //responde ao Get
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //requisição aceita um id pelo url
	public ResponseEntity<Order> findById(@PathVariable Long id){ //path variable por causa do parâmetro da url
		
		Order Order = service.findById(id);
		return ResponseEntity.ok().body(Order);
	}
}
		