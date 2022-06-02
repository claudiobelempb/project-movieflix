package br.com.surb.surb.modules.user.useCases.UserUpdate;

import br.com.surb.surb.modules.role.dto.RoleDTO;
import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import br.com.surb.surb.modules.role.infra.jpa.repositories.RoleRepository;
import br.com.surb.surb.modules.user.dto.UserDTO;
import br.com.surb.surb.modules.user.dto.UserUpdateDTO;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import br.com.surb.surb.shared.constants.AppExceptionConstants;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class UserUpdateService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  public UserUpdateService(UserRepository userRepository, RoleRepository roleRepository){
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }

  @Transactional
  public UserDTO execute(Long id, UserUpdateDTO userUpdateDTO){
    try{
      User user = userRepository.getById(id);
      copyDtoToUser(userUpdateDTO, user);
      user = userRepository.save(user);
      return new UserDTO(user);
    }catch (EntityNotFoundException e){
      throw new AppNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }

  private void copyDtoToUser(UserUpdateDTO userUpdateDTO, User user) {
    user.setFirstName(userUpdateDTO.getFirstName());
    user.setLastName(userUpdateDTO.getLastName());
    user.setEmail(userUpdateDTO.getEmail());

    user.getRoles().clear();
    for (RoleDTO roleDTO : userUpdateDTO.getRoles()) {
      Role role = roleRepository.getById(roleDTO.getId());
      user.getRoles().add(role);
    }
  }
}
