package br.com.surb.surb.modules.user.dto;

import br.com.surb.surb.modules.user.useCases.UserUpdate.validation.UserUpdateValid;

import java.io.Serializable;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String password;

  public UserUpdateDTO() {
    super();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
