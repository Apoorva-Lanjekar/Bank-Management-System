package com.example.javademo.test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.javademo.controllers.UserController;

@SpringBootTest
public class TestingControllerClass {
 
  @Autowired
  UserController userController;
 
  @Test
  public void contextLoads() {
    Assertions.assertThat(userController).isNot(null);
  }
}