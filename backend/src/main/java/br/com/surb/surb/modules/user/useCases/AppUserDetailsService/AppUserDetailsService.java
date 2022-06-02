package br.com.surb.surb.modules.user.useCases.AppUserDetailsService;

import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import br.com.surb.surb.shared.constants.AppExceptionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;
  private static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

  public AppUserDetailsService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String usernameEmail) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(usernameEmail);

    if (user == null) {
      logger.error(AppExceptionConstants.USER_NOT_FOUND + usernameEmail);
      throw new UsernameNotFoundException(AppExceptionConstants.EMAIL_NOT_FOUND + usernameEmail);
    }

    logger.info(AppExceptionConstants.USER_FOUND + usernameEmail);
    return user;
  }
}
