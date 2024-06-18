package com.example.javademo.exception;

public class AccountDoesNotExistsException extends RuntimeException{
	private String message;
	 
	 public AccountDoesNotExistsException(String message) {
		 super(message);
	     this.message = message;
	 }
	 
	 public AccountDoesNotExistsException() {
		 
	 }
}
