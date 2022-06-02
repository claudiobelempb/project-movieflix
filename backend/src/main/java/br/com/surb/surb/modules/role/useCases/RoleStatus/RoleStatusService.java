package br.com.surb.surb.modules.role.useCases.RoleStatus;

import static br.com.surb.surb.shared.constants.AppExceptionConstants.*;

import br.com.surb.surb.modules.role.dto.RoleUpdateDTO;
import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import br.com.surb.surb.modules.role.infra.jpa.repositories.RoleRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class RoleStatusService {

  private final RoleRepository roleRepository;

  public RoleStatusService(RoleRepository roleRepository){
    this.roleRepository = roleRepository;
  }

  @Transactional
  public void execute(Long id, RoleUpdateDTO roleUpdateDTO){
    try{
      Role role = roleRepository.getById(id);
      role.setStatus(roleUpdateDTO.getStatus());
      roleRepository.save(role);
    }catch (EntityNotFoundException e){
      throw new AppNotFoundException(ENTITY_NOT_FOUND + id);
    }
  }
}
