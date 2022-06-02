package br.com.surb.surb.modules.user.dto;

import br.com.surb.surb.modules.user.useCases.UserCreate.validation.UserCreateValid;

@UserCreateValid
public class UserCreateDTO extends UserDTO {

  private static final long serialVersionUID = 1L;

  private String password;

  public UserCreateDTO(){
    super();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
