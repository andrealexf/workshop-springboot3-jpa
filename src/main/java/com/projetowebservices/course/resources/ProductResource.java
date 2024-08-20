package com.projetowebservices.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetowebservices.course.entities.Product;
import com.projetowebservices.course.services.ProductService;

@RestController //é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/products") //nome 
public class ProductResource {
	
	@Autowired
	private ProductService service;

	@GetMapping //responde ao Get
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //requisição aceita um id pelo url
	public ResponseEntity<Product> findById(@PathVariable Long id){ //path variable por causa do parâmetro da url
		
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
		