package com.example.javademo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.javademo.models.User;
import com.example.javademo.repository.UserRepository;
import com.example.javademo.service.UserService;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

  @InjectMocks
  UserService service;

  @Mock
  UserRepository dao;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindAllUsers() {
    List<User> list = new ArrayList<User>();
    User empOne = new User(0, "Apoorva", "Lanjekar", null);
    User empTwo = new User(0, "Alex", "Russo", null);
    User empThree = new User(0, "Steve", "Martin", null);

    list.add(empOne);
    list.add(empTwo);
    list.add(empThree);

    when(dao.findAll()).thenReturn(list);

    //test
    List<User> empList = service.getAllUsers();

    assertEquals(3, empList.size());
    verify(dao, times(1)).findAll();
  }

  @Test
  void testCreateOrSaveUser() {
    User user = new User(0, "Anita", "Gupta", null);

    service.saveUser(user);

    verify(dao, times(1)).save(user);
  }
}