package dev.aleoliv.demomobileapi.mappers;

import org.springframework.stereotype.Component;

import dev.aleoliv.demomobileapi.dtos.UserDTO;
import dev.aleoliv.demomobileapi.models.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class UserMapper extends ConfigurableMapper {

  @Override
  protected void configure(MapperFactory factory) {
    factory.classMap(User.class, UserDTO.class)
      .field("email", "email")
      .field("fullName", "fullName")
      .byDefault()
      .register();
  }
}
