package com.example.javademo.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.example.javademo.exception.UserAlreadyExistsException;
import com.example.javademo.exception.UsreNotFoundException;
import com.example.javademo.models.User;
import com.example.javademo.repository.UserRepository;
import com.example.javademo.service.BankAccountService;
import com.example.javademo.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	@Override
	public List<User> getAllUsers() throws UsreNotFoundException {
		return repository.findAll();
	}

	@Override
	public User saveUser(User user) throws UserAlreadyExistsException {
		if(this.repository.existsById((long) user.getId())) {
			throw new UserAlreadyExistsException("user already exists");
		}
		return this.repository.save(user);
	}

	@Override
	public void deleteUserById(Long id) throws UsreNotFoundException {
		this.repository.deleteById(id);
		
	}

	@Override
	public User getUserById(String id) throws UsreNotFoundException {
		Optional<User> optional = repository.findById(Long.parseLong(id));
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new UsreNotFoundException(" User not found for id :: " + id);
		}
		return user;
	}

	@Override
	public User getUserByAccountId(String id) throws UsreNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User newData) throws UsreNotFoundException {
		Optional<User> user = repository.findById((long) newData.getId());
		if (!ObjectUtils.isEmpty(user)) {
			User u = user.get(); 
			u.setName(newData.getName());
            u.setAddress(newData.getAddress());
            return repository.save(u);
		} else {
			return repository.save(newData);			
		}
	}

}
