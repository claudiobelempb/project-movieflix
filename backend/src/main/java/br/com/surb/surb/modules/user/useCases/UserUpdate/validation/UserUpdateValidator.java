package br.com.surb.surb.modules.user.useCases.UserUpdate.validation;

import static br.com.surb.surb.shared.constants.AppValidatorConstants.REQUIRED_EMAIL_EXIST;

import br.com.surb.surb.modules.user.dto.UserUpdateDTO;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import br.com.surb.surb.shared.exeptions.resources.AppFieldMessage;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

  private final UserRepository userRepository;
  private final HttpServletRequest httpServletRequest;

  public UserUpdateValidator(UserRepository userRepository, HttpServletRequest httpServletRequest){
    this.userRepository = userRepository;
    this.httpServletRequest = httpServletRequest;
  }

  @Override
  public void initialize(UserUpdateValid ann) {
  }

  @Override
  public boolean isValid(UserUpdateDTO userUpdateDTO, ConstraintValidatorContext context) {

    @SuppressWarnings("unchecked")
    var uri = (Map<String, String>) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    long userId = Long.parseLong(uri.get("id"));

    List<AppFieldMessage> fieldMessages = new ArrayList<>();

    // Coloque aqui seus testes de validação, acrescentando objetos AppFieldMessage à lista
    User user = userRepository.findByEmail(userUpdateDTO.getEmail());
    if (user != null && userId != user.getId()) {
      fieldMessages.add(new AppFieldMessage("email", REQUIRED_EMAIL_EXIST));
    }


    for (AppFieldMessage error : fieldMessages) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(error.getMessage()).addPropertyNode(error.getFieldName())
        .addConstraintViolation();
    }
    return fieldMessages.isEmpty();
  }

}


