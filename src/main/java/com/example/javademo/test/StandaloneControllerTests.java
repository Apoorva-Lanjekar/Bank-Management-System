package com.example.javademo.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.javademo.controllers.UserController;
import com.example.javademo.models.User;
import com.example.javademo.service.UserService;


@WebMvcTest(UserController.class)
public class StandaloneControllerTests {

  @MockBean
  UserService userService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void testfindAll() throws Exception {
    User user = new User(0, "Apoorva", "Lanjekar", null);
    List<User> users = Arrays.asList(user);

    Mockito.when(userService.getAllUsers()).thenReturn(users);

    mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[0].firstName", Matchers.is("Apoorva")));
  }

}