package com.example.javademo.exception;

public class AccountAlreadyExisitsException extends RuntimeException{
 private String message;
	 
	 public AccountAlreadyExisitsException(String message) {
		 super(message);
	     this.message = message;
	 }
	 
	 public AccountAlreadyExisitsException() {
		 
	 }
}
