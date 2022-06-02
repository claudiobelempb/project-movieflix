package br.com.surb.surb.modules.notification.useCases.NotificationFindAllUser;

import br.com.surb.surb.modules.notification.dto.NotificationDTO;
import br.com.surb.surb.modules.notification.infra.entities.Notification;
import br.com.surb.surb.modules.notification.infra.repositories.NotificationRepository;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.useCases.AppUserAuthService.AppUserAuthService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationFindAllUserService {

  private final NotificationRepository notificationRepository;
  private final AppUserAuthService appUserAuthService;

  public NotificationFindAllUserService(
    NotificationRepository notificationRepository,
    AppUserAuthService appUserAuthService
  ){
    this.notificationRepository = notificationRepository;
    this.appUserAuthService = appUserAuthService;
  }

  @Transactional(readOnly = true)
  public Page<NotificationDTO> execute(Pageable pageable){
    //pega o user authenticate
    User user = appUserAuthService.authenticated();
    Page<Notification> notifications = notificationRepository.findByUser(user, pageable);
    return notifications.map(notification -> new NotificationDTO(notification));
  }
}
