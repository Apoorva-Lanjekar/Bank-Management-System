package com.example.javademo.exception;

public class UsreNotFoundException extends RuntimeException {
	private String message;
	 
	 public UsreNotFoundException(String message) {
		 super(message);
	     this.message = message;
	 }
	 
	 public UsreNotFoundException() {
		 
	 }
}
