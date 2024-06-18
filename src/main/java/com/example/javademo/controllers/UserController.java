package com.example.javademo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javademo.exception.AccountDoesNotExistsException;
import com.example.javademo.exception.UserAlreadyExistsException;
import com.example.javademo.exception.UsreNotFoundException;
import com.example.javademo.models.BankAccount;
import com.example.javademo.models.User;
import com.example.javademo.serviceImplementation.BankAccountServiceImpl;
import com.example.javademo.serviceImplementation.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	BankAccountServiceImpl accountServiceImpl;
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(User user) {
		User result = null;
		try {
			if (!ObjectUtils.isEmpty(user)) {
				result = userServiceImpl.saveUser(user);			
			}
		} catch( UserAlreadyExistsException e) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/account")
	public ResponseEntity<BankAccount> createAccount(BankAccount account) {
		BankAccount result = null;
		try {
			if (!ObjectUtils.isEmpty(account)) {
				result = accountServiceImpl.createAccount(account);		
			}
		} catch( UserAlreadyExistsException e) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return ResponseEntity.ok(userServiceImpl.getAllUsers());
		} catch(UsreNotFoundException e ) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<List<BankAccount>> getAllAccount() {
		try {
			return ResponseEntity.ok(accountServiceImpl.getAllAccounts());
		} catch(UsreNotFoundException e ) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/usersById/{id}") 
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		User usr = null;
		try {
			usr = this.userServiceImpl.getUserById(id);
		} catch (UsreNotFoundException e) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(usr);
	}
	
	@GetMapping("/accountById/{id}") 
	public ResponseEntity<BankAccount> getEmployeeById(@PathVariable("id") String id) {
		BankAccount ac = null;
		try {
			ac = this.accountServiceImpl.getAccountById(id);
		} catch (UsreNotFoundException e) {
			System.out.println(e);
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(ac);
	}
	
	 @PutMapping("/user")
	 public ResponseEntity<User> updateUser(@RequestBody User user) {
		 User usr = null;
			try {
				usr = this.userServiceImpl.updateUser(user);
			} catch (UsreNotFoundException e) {
				System.out.println(e);
				return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
			} catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.ok(usr);
	        
	    }
	 
	 @DeleteMapping("/user/{id}")
	 public String deleteUserById(@PathVariable("id") String id) {
		 try {
				this.userServiceImpl.deleteUserById(Long.parseLong(id));
				return "User deleted successfully";
			} catch (UsreNotFoundException e) {
				System.out.println(e);
				return e.getMessage();
			} catch(Exception ex) {
				System.out.println(ex);
				return "Error deleting USer";
			}
	 }
	 
	 @DeleteMapping("/account/{id}")
	 public String deleteAccountById(@PathVariable("id") String id) {
		 try {
				this.accountServiceImpl.deleteAccountById(Long.parseLong(id));
				return "Account Deleted Successfully";
			} catch (AccountDoesNotExistsException e) {
				System.out.println(e);
				return e.getMessage();
			} catch(Exception ex) {
				return "Error Deleting Account";
			}
	 }
}
