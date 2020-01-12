package dev.aleoliv.demomobileapi.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.aleoliv.demomobileapi.exceptions.UserNotFoundException;
import dev.aleoliv.demomobileapi.models.User;
import dev.aleoliv.demomobileapi.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public List<User> all() {
    return userRepository.findAll();
  }

  public List<User> all(Map<String, Object> params) {
    return null;
  }

  public User find(Long id) throws UserNotFoundException {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      return optionalUser.get();
    }
    throw new UserNotFoundException();
  }

  public User save(User user) {
    return userRepository.saveAndFlush(user);
  }

  public User update(User user) {
    return userRepository.saveAndFlush(user);
  }

  public void delete(Long id) throws UserNotFoundException {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      userRepository.delete(optionalUser.get());
    }
    throw new UserNotFoundException();
  }
}
