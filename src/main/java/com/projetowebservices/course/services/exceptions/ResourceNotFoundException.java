package com.projetowebservices.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {//dará uma exceção quando o id não for encontrado
		
		super("Resource not found. Id: " + id);
	}
}
