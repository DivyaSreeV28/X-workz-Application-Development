package com.xworkz.springbootweb.exceptions;

public class FieldNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public FieldNotFoundException(String message) {
		super(message);
	}

}
