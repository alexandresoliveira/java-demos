package dev.aleoliv.demomobileapi.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import dev.aleoliv.demomobileapi.services.UserService;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("tst")
public class UserControllerTest {

  @MockBean
  UserService userService;

  @Autowired
  MockMvc mockMvc;
  
  @Test
  public void getUsers_ShouldReturnEmpytArray() throws Exception {
    when(userService.all()).thenReturn(Arrays.asList());
    
    mockMvc.perform(get("/users"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$").isArray())
      .andExpect(jsonPath("$", hasSize(0)));
  }
  
  
}
