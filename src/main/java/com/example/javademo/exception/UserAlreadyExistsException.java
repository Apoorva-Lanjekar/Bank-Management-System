package com.example.javademo.exception;

public class UserAlreadyExistsException extends RuntimeException {
	 private String message;
	 
	 public UserAlreadyExistsException(String message) {
		 super(message);
	     this.message = message;
	 }
	 
	 public UserAlreadyExistsException() {
		 
	 }
}
