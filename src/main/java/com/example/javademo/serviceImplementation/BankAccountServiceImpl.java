package com.example.javademo.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.javademo.exception.AccountAlreadyExisitsException;
import com.example.javademo.exception.AccountDoesNotExistsException;
import com.example.javademo.exception.UserAlreadyExistsException;
import com.example.javademo.exception.UsreNotFoundException;
import com.example.javademo.models.BankAccount;
import com.example.javademo.models.User;
import com.example.javademo.repository.BankRepository;
import com.example.javademo.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	BankRepository bankRepository;
	
	@Override
	public List<BankAccount> getAllAccounts() throws AccountDoesNotExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount createAccount(BankAccount acc) throws AccountAlreadyExisitsException {
		if(this.bankRepository.existsById((long) acc.getId())) {
			throw new UserAlreadyExistsException("Employee already exists");
		}
		return this.bankRepository.save(acc);
	}

	@Override
	public void deleteAccountById(Long id) throws AccountDoesNotExistsException {
		this.bankRepository.deleteById(id);
		
	}

	@Override
	public BankAccount getAccountById(String id) throws AccountDoesNotExistsException {
		Optional<BankAccount> optional = bankRepository.findById(Long.parseLong(id));
		BankAccount acc = null;
		if (optional.isPresent()) {
			acc = optional.get();
		} else {
			throw new UsreNotFoundException(" Employee not found for id :: " + id);
		}
		return acc;
	}

	@Override
	public BankAccount getAccountsByUserId(String id) throws AccountDoesNotExistsException {
		// TODO Auto-generated method stub
		return null;
	}

}
