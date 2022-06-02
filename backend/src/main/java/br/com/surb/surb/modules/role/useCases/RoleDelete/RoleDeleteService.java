package br.com.surb.surb.modules.role.useCases.RoleDelete;

import static br.com.surb.surb.shared.constants.AppExceptionConstants.ENTITY_NOT_FOUND;
import static br.com.surb.surb.shared.constants.AppExceptionConstants.INTEGRITY_VIOLATION;

import br.com.surb.surb.modules.role.infra.jpa.repositories.RoleRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import br.com.surb.surb.shared.exeptions.services.AppDataBaseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RoleDeleteService {

  private final RoleRepository roleRepository;

  public RoleDeleteService(RoleRepository roleRepository){
    this.roleRepository = roleRepository;
  }

  public void execute(Long id){
    try{
      roleRepository.deleteById(id);
    }catch (EmptyResultDataAccessException e){
      throw new AppNotFoundException(ENTITY_NOT_FOUND + id);
    }catch (DataIntegrityViolationException e){
      throw new AppDataBaseException(INTEGRITY_VIOLATION);
    }
  }
}
