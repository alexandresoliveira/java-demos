package br.com.aleoliv.demospringsecurity.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountCredentials {
  
  private String username;
  private String password;
}
