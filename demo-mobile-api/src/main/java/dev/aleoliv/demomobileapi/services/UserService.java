package dev.aleoliv.demomobileapi.services;

import java.util.List;
import java.util.Map;

import dev.aleoliv.demomobileapi.exceptions.UserNotFoundException;
import dev.aleoliv.demomobileapi.models.User;

public interface UserService {

  List<User> all();

  List<User> all(Map<String, Object> params);

  User find(Long id) throws UserNotFoundException;

  User save(User userDTO);

  User update(User userDTO);

  void delete(Long id) throws UserNotFoundException;

}
