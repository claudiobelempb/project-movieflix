package br.com.surb.surb.modules.user.useCases.AppUserAuthService;

import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import br.com.surb.surb.shared.constants.AppExceptionConstants;
import br.com.surb.surb.shared.exeptions.services.AppForbiddenException;
import br.com.surb.surb.shared.exeptions.services.AppUnauthorizedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserAuthService {

  private final UserRepository userRepository;

  public AppUserAuthService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Transactional(readOnly = true)
  public User authenticated(){
    try{
      String username = SecurityContextHolder.getContext().getAuthentication().getName();
      return userRepository.findByEmail(username);
    }catch (Exception e) {
      throw new AppUnauthorizedException(AppExceptionConstants.INVALID_USER);
    }
  }

  public void validateSelfOrAdmin(Long userId){
    User user = authenticated();
    if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
      throw new AppForbiddenException(AppExceptionConstants.ACCESS_DENIED);
    }
  }
}
