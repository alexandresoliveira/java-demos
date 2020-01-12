package dev.aleoliv.demomobileapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.aleoliv.demomobileapi.exceptions.UserNotFoundException;
import dev.aleoliv.demomobileapi.models.User;
import dev.aleoliv.demomobileapi.services.UserService;

@RestController
@RequestMapping(name = "users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  public List<User> index() {
    return userService.all();
  }

  @GetMapping(path = "{id}")
  public User show(@PathVariable("id") Long id) {
    try {
      return userService.find(id);
    } catch (UserNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", e);
    }
  }

  @PostMapping
  public User save(User user) {
    return userService.save(user);
  }

  @PutMapping
  public User update(User user) {
    return userService.update(user);
  }

  @DeleteMapping(path = "{id}")
  public void delete(@PathVariable("id") Long id) {
    try {
      userService.delete(id);
    } catch (UserNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", e);
    }
  }
}
