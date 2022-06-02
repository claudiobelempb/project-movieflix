package br.com.surb.surb.modules.role.useCases.RoleUpdate;

import br.com.surb.surb.modules.role.dto.RoleUpdateDTO;
import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import br.com.surb.surb.modules.role.infra.jpa.repositories.RoleRepository;
import br.com.surb.surb.shared.constants.AppExceptionConstants;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class RoleUpdateService {

  private final RoleRepository roleRepository;

  public RoleUpdateService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Transactional
  public RoleUpdateDTO execute(Long id, RoleUpdateDTO roleUpdateDTO) {
    try{
      Role role = new Role();
      role.setAuthority(roleUpdateDTO.getAuthority());
      role = roleRepository.save(role);
      return new RoleUpdateDTO(role);
    }catch (EntityNotFoundException e){
      throw new AppNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
