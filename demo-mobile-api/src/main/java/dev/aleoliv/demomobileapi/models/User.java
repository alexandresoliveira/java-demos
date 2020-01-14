package dev.aleoliv.demomobileapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends Base {

  /**
   * 
   */
  private static final long serialVersionUID = 3373151701698165289L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Email
  @Column(name = "email", length = 30, nullable = false)
  private String email;

  @NotBlank
  @Size(min = 3, max = 100)
  @Column(name = "full_name", length = 100, nullable = false)
  private String fullName;

  public User(String email, String fullName) {
    this.email = email;
    this.fullName = fullName;
  }
}
