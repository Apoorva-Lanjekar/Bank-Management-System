package com.example.javademo.service;

import java.util.List;

import com.example.javademo.exception.AccountAlreadyExisitsException;
import com.example.javademo.exception.AccountDoesNotExistsException;
import com.example.javademo.exception.UserAlreadyExistsException;
import com.example.javademo.exception.UsreNotFoundException;
import com.example.javademo.models.BankAccount;
import com.example.javademo.models.User;

public interface BankAccountService {
	List<BankAccount> getAllAccounts() throws AccountDoesNotExistsException;
	BankAccount createAccount(BankAccount acc) throws AccountAlreadyExisitsException;
	void deleteAccountById(Long id) throws AccountDoesNotExistsException;
	BankAccount getAccountById(String id) throws AccountDoesNotExistsException;
	BankAccount getAccountsByUserId(String id) throws AccountDoesNotExistsException;
}
