package br.com.surb.surb.modules.user.useCases.UserFindById;

import static br.com.surb.surb.shared.constants.AppExceptionConstants.ENTITY_NOT_FOUND;

import br.com.surb.surb.modules.user.dto.UserDTO;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import br.com.surb.surb.modules.user.useCases.AppUserAuthService.AppUserAuthService;
import br.com.surb.surb.shared.exeptions.services.AppNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserFindByIdService {

  private final UserRepository userRepository;
  private final AppUserAuthService appUserAuthService;

  public UserFindByIdService(
    UserRepository userRepository,
    AppUserAuthService appUserAuthService
  ) {
    this.userRepository = userRepository;
    this.appUserAuthService = appUserAuthService;
  }

  @Transactional(readOnly = true)
  public UserDTO execute(Long id) {

    appUserAuthService.validateSelfOrAdmin(id);

    Optional<User> obj = userRepository.findById(id);
    User user = obj.orElseThrow(() -> new AppNotFoundException(ENTITY_NOT_FOUND + id));
    return new UserDTO(user);
  }

  public UserRepository userRepository() {
    return userRepository;
  }

  public AppUserAuthService appUserAuthService() {
    return appUserAuthService;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (UserFindByIdService) obj;
    return Objects.equals(this.userRepository, that.userRepository) &&
      Objects.equals(this.appUserAuthService, that.appUserAuthService);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userRepository, appUserAuthService);
  }

  @Override
  public String toString() {
    return "UserFindByIdService[" +
      "userRepository=" + userRepository + ", " +
      "appUserAuthService=" + appUserAuthService + ']';
  }


}
