package dev.aleoliv.demomobileapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.aleoliv.demomobileapi.exceptions.UserNotFoundException;
import dev.aleoliv.demomobileapi.models.User;
import dev.aleoliv.demomobileapi.services.UserService;

@RestController
@RequestMapping(value = "users", produces = {
    MediaType.APPLICATION_JSON_VALUE })
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public @ResponseBody List<User> index() {
    return userService.all();
  }

  @GetMapping(path = "{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public @ResponseBody User show(@PathVariable("id") Long id) {
    try {
      return userService.find(id);
    } catch (UserNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", e);
    }
  }

  @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseStatus(code = HttpStatus.CREATED)
  public @ResponseBody User save(@Valid @RequestBody User user) {
    return userService.save(user);
  }

  @PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseStatus(code = HttpStatus.ACCEPTED)
  public @ResponseBody User update(@Valid @RequestBody User user) {
    return userService.update(user);
  }

  @DeleteMapping(path = "{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    try {
      userService.delete(id);
    } catch (UserNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", e);
    }
  }
}
