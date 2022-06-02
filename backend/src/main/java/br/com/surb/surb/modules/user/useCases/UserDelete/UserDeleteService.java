package br.com.surb.surb.modules.user.useCases.UserDelete;

import static br.com.surb.surb.shared.constants.AppExceptionConstants.ENTITY_NOT_FOUND;
import static br.com.surb.surb.shared.constants.AppExceptionConstants.INTEGRITY_VIOLATION;

import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import br.com.surb.surb.shared.exeptions.services.AppDataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteService {

  @Autowired
  private UserRepository userRepository;

  public void execute(Long id){
    try{
      userRepository.deleteById(id);
    }catch (EmptyResultDataAccessException e) {
      throw new AppNotFoundException(ENTITY_NOT_FOUND + id);
    }catch (DataIntegrityViolationException e) {
      throw new AppDataBaseException(INTEGRITY_VIOLATION);
    }
  }
}
