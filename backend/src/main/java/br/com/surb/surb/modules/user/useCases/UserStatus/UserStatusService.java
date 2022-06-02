package br.com.surb.surb.modules.user.useCases.UserStatus;

import br.com.surb.surb.modules.user.dto.UserUpdateDTO;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import br.com.surb.surb.shared.constants.AppExceptionConstants;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class UserStatusService {

  private final UserRepository userRepository;

  public UserStatusService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void execute(Long id, UserUpdateDTO userDTO) {
    try{
      User user = userRepository.getById(id);
      user.setStatus(userDTO.getStatus());
      userRepository.save(user);
    }catch (EntityNotFoundException e) {
      throw new AppNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
