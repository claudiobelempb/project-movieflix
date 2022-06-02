package br.com.surb.surb.modules.user.useCases.UserFindAll;

import br.com.surb.surb.modules.user.dto.UserDTO;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserFindAllService {

  @Autowired
  private UserRepository iUserRepository;

  @Transactional(readOnly = true)
  public Page<UserDTO> execute(Pageable pageable) {
    Page<User> users = iUserRepository.findAll(pageable);
    return users.map(user -> new UserDTO(user));
  }
}
