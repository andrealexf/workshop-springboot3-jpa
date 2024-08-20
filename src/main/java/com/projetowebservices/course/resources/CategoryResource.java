package com.projetowebservices.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetowebservices.course.entities.Category;
import com.projetowebservices.course.services.CategoryService;

@RestController //é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/categories") //nome 
public class CategoryResource {
	
	@Autowired
	private CategoryService service;

	@GetMapping //responde ao Get
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //requisição aceita um id pelo url
	public ResponseEntity<Category> findById(@PathVariable Long id){ //path variable por causa do parâmetro da url
		
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
		