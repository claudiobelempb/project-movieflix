package br.com.surb.surb.modules.role.useCases.RoleCreate;

import br.com.surb.surb.modules.role.dto.RoleCreateDTO;
import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import br.com.surb.surb.modules.role.infra.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleCreateService {

  private final RoleRepository roleRepository;

  public RoleCreateService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Transactional
  public RoleCreateDTO execute(RoleCreateDTO roleDTO){
    Role role = new Role();
    role.setAuthority(roleDTO.getAuthority());
    role = roleRepository.save(role);
    return new RoleCreateDTO(role);
  }
}
