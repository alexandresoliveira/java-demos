package br.com.aleoliv.demospringsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

  @GetMapping
  public String index() {
    return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}," +
        "{\"name\":\"Jackie\",\"country\":\"China\"}]}";
  }
}