package br.com.surb.surb.modules.notification.infra.repositories;

import br.com.surb.surb.modules.notification.infra.entities.Notification;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
  Page<Notification> findByUser(User user, Pageable pageable);
}
