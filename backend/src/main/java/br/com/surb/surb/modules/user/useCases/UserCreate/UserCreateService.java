package br.com.surb.surb.modules.user.useCases.UserCreate;

import br.com.surb.surb.modules.role.dto.RoleDTO;
import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import br.com.surb.surb.modules.role.infra.jpa.repositories.RoleRepository;
import br.com.surb.surb.modules.user.dto.UserCreateDTO;
import br.com.surb.surb.modules.user.dto.UserDTO;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCreateService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UserCreateService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Transactional
  public UserDTO execute(UserCreateDTO userCreateDTO) {
    User user = new User();
    copyDtoToUser(userCreateDTO, user);
    user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
    user = userRepository.save(user);
    return new UserDTO(user);
  }

  private void copyDtoToUser(UserDTO userDTO, User user) {
    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());
    user.setEmail(userDTO.getEmail());

    user.getRoles().clear();
    for (RoleDTO roleDTO : userDTO.getRoles()) {
      Role role = roleRepository.getOne(roleDTO.getId());
      user.getRoles().add(role);
    }
  }

}
