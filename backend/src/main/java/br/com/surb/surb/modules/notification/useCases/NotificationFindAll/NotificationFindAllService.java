package br.com.surb.surb.modules.notification.useCases.NotificationFindAll;

import br.com.surb.surb.modules.notification.dto.NotificationDTO;
import br.com.surb.surb.modules.notification.infra.entities.Notification;
import br.com.surb.surb.modules.notification.infra.repositories.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationFindAllService {

  private final NotificationRepository notificationRepository;

  public NotificationFindAllService(
    NotificationRepository notificationRepository
  ){
    this.notificationRepository = notificationRepository;
  }

  @Transactional(readOnly = true)
  public Page<NotificationDTO> execute(Pageable pageable){
    Page<Notification> notifications = notificationRepository.findAll(pageable);
    return notifications.map(notification -> new NotificationDTO(notification));
  }
}
