package dev.aleoliv.demomobileapi.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.aleoliv.demomobileapi.models.Base;

public interface Controller<T extends Base> {

  @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  List<T> index(@RequestParam Map<String, Object> params);

  @GetMapping(path = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseStatus(code = HttpStatus.OK)
  @ResponseBody
  T show(@PathVariable("id") Long id);

  @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseStatus(code = HttpStatus.CREATED)
  @ResponseBody
  T store(@Valid @RequestBody T model);

  @PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseStatus(code = HttpStatus.CREATED)
  @ResponseBody
  T update(@Valid @RequestBody T model);

  @DeleteMapping(path = "{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  void delete(@PathVariable("id") Long id);
}
