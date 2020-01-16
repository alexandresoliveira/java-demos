package dev.aleoliv.demomobileapi.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.aleoliv.demomobileapi.exceptions.UserNotFoundException;
import dev.aleoliv.demomobileapi.models.User;
import dev.aleoliv.demomobileapi.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController implements Controller<User> {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Override
  public List<User> index(Map<String, Object> params) {
    return userService.all();
  }

  @Override
  public User show(Long id) {
    try {
      return userService.find(id);
    } catch (UserNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NO_CONTENT, "User Not Found", e);
    }
  }

  @Override
  public User store(@Valid User model) {
    return userService.save(model);
  }

  @Override
  public User update(@Valid User model) {
    return userService.update(model);
  }

  @Override
  public void delete(Long id) {
    try {
      userService.delete(id);
    } catch (UserNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NO_CONTENT, "User Not Found", e);
    }
  }

}
