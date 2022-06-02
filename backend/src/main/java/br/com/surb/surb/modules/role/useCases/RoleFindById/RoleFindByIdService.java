package br.com.surb.surb.modules.role.useCases.RoleFindById;

import static br.com.surb.surb.shared.constants.AppExceptionConstants.ENTITY_NOT_FOUND;

import br.com.surb.surb.modules.role.dto.RoleDTO;
import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import br.com.surb.surb.modules.role.infra.jpa.repositories.RoleRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleFindByIdService {

  private final RoleRepository roleRepository;

  public RoleFindByIdService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public RoleDTO execute(Long id) {
    Optional<Role> obj = roleRepository.findById(id);
    Role role = obj.orElseThrow(() -> new AppNotFoundException(ENTITY_NOT_FOUND + id));
    return new RoleDTO(role);
  }
}
