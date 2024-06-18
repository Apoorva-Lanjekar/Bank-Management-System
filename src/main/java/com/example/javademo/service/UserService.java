package com.example.javademo.service;

import java.util.List;

import com.example.javademo.exception.UserAlreadyExistsException;
import com.example.javademo.exception.UsreNotFoundException;
import com.example.javademo.models.User;

public interface UserService {
	List<User> getAllUsers() throws UsreNotFoundException;
	User saveUser(User user) throws UserAlreadyExistsException;
	void deleteUserById(Long id) throws UsreNotFoundException;
	User getUserById(String id) throws UsreNotFoundException;
	User getUserByAccountId(String id) throws UsreNotFoundException;
	User updateUser(User user) throws UsreNotFoundException;
}
