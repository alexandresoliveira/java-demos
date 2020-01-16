package dev.aleoliv.demomobileapi.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.Arrays;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import dev.aleoliv.demomobileapi.exceptions.UserNotFoundException;
import dev.aleoliv.demomobileapi.models.User;
import dev.aleoliv.demomobileapi.services.UserService;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserControllerTestD {

  @LocalServerPort
  private int localPort;

  @Autowired
  TestRestTemplate testRestTemplate;

  @MockBean
  UserService userService;

  @Test
  public void indexUsers_ShouldReturnEmpytList() {
    when(userService.all()).thenReturn(Arrays.asList());

    String baseUrl = String.format("http://localhost:%s/users/", localPort);
    ResponseEntity<User[]> responseEntity = testRestTemplate.getForEntity(baseUrl, User[].class);
    MatcherAssert.assertThat(responseEntity.getBody().length, is(equalTo(0)));
  }

  @Test
  public void indexUsers_ShouldReturnUsers() {
    when(userService.all()).thenReturn(Arrays.asList(new User(), new User()));

    String baseUrl = String.format("http://localhost:%s/users/", localPort);
    ResponseEntity<User[]> responseEntity = testRestTemplate.getForEntity(baseUrl, User[].class);
    MatcherAssert.assertThat(responseEntity.getBody().length, is(equalTo(2)));
  }

  @Test
  public void showUser_ShouldReturnValidUser() throws UserNotFoundException {
    User user = new User("alexandre@email.com", "Alexandre");
    when(userService.find(1l)).thenReturn(user);

    String baseUrl = String.format("http://localhost:%s/users/1", localPort);
    ResponseEntity<User> responseEntity = testRestTemplate.getForEntity(baseUrl, User.class);
    MatcherAssert.assertThat(responseEntity.getBody().getEmail(), is(equalTo(user.getEmail())));
    MatcherAssert.assertThat(responseEntity.getBody().getFullName(), is(equalTo(user.getFullName())));
  }

  @Test
  public void showUser_ShouldReturnExceptionWithNotFound() throws UserNotFoundException {
    when(userService.find(-1l)).thenThrow(UserNotFoundException.class);

    String baseUrl = String.format("http://localhost:%s/users/-1", localPort);
    UserNotFoundException exception = assertThrows(UserNotFoundException.class,
        () -> testRestTemplate.getForEntity(baseUrl, User.class));
    MatcherAssert.assertThat(exception.getMessage(), is(equalTo("User not found")));
  }
}
