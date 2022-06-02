package br.com.surb.surb.modules.role.useCases.RoleFindAll;

import br.com.surb.surb.modules.role.dto.RoleDTO;
import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import br.com.surb.surb.modules.role.infra.jpa.repositories.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleFindAllService {

  private final RoleRepository roleRepository;

  public RoleFindAllService(RoleRepository roleRepository){
    this.roleRepository = roleRepository;
  }

  @Transactional(readOnly = true)
  public Page<RoleDTO> execute(Pageable pageable){
    Page<Role> roles = roleRepository.findAll(pageable);
    return roles.map(role -> new RoleDTO(role));
  }
}
