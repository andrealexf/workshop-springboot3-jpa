package com.projetowebservices.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetowebservices.course.entities.User;
import com.projetowebservices.course.repositories.UserRepository;
import com.projetowebservices.course.resources.exceptions.DatabaseException;
import com.projetowebservices.course.services.exceptions.ResourceNotFoundException;
 
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public User findById(Long id) {
		
		Optional <User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		
		return repository.save(obj);//insere no banco de dados um obj tipo user
	}
	
	public void delete(Long id){
		
		if(!repository.existsById(id)) {
		
			throw new ResourceNotFoundException(id);
		}
		
//		try {
//			
//			repository.deleteById(id);
//				
//		} catch (ResourceNotFoundException e) {
//		
//			throw new ResourceNotFoundException(id);
//		}
		
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {

			throw new ResourceNotFoundException(id);
			
		} catch (DataIntegrityViolationException e) {

			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj){
		
		User entity = repository.getReferenceById(id);//deixa um objeto preparado para mexer, mas não insere ainda no banco de dados
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {

		entity.setName(obj.getName()); //name do entity vira o name do obj
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
