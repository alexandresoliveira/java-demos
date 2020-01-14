package dev.aleoliv.demomobileapi.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO {

  @NotBlank
  @Email
  private String email;

  @NotBlank
  @Size(min = 3, max = 100)
  private String fullName;
}
