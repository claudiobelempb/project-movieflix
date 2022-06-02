package br.com.surb.surb.modules.user.useCases.UserCreate.validation;

import static br.com.surb.surb.shared.constants.AppValidatorConstants.REQUIRED_EMAIL_EXIST;

import br.com.surb.surb.modules.user.dto.UserCreateDTO;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import br.com.surb.surb.shared.exeptions.resources.AppFieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserCreateValidator implements ConstraintValidator<UserCreateValid, UserCreateDTO> {

  private final UserRepository userRepository;

  public UserCreateValidator(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public void initialize(UserCreateValid ann) {
  }

  @Override
  public boolean isValid(UserCreateDTO userCreateDTO, ConstraintValidatorContext context) {

    List<AppFieldMessage> list = new ArrayList<>();

    // Coloque aqui seus testes de validação, acrescentando objetos AppFieldMessage à lista
    User userEmail = userRepository.findByEmail(userCreateDTO.getEmail());
    if(userEmail != null){
      list.add(new AppFieldMessage("email", REQUIRED_EMAIL_EXIST));
    }


    for (AppFieldMessage error : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(error.getMessage()).addPropertyNode(error.getFieldName())
        .addConstraintViolation();
    }
    return list.isEmpty();
  }
}


