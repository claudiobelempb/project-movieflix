package br.com.surb.surb.modules.notification.dto;

import br.com.surb.surb.modules.notification.infra.entities.Notification;

import java.io.Serializable;
import java.time.Instant;

public class NotificationDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String text;
  private boolean read;
  private String route;
  private Instant createdAt;
  private Instant updatedAt;
  private boolean status;
  private Long userId;

  public NotificationDTO(){}

  public NotificationDTO(Long id, String text, boolean read, String route, Instant createdAt, Instant updatedAt,
                         boolean status, Long userId) {
    this.id = id;
    this.text = text;
    this.read = read;
    this.route = route;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
    this.userId = userId;
  }

  public NotificationDTO(Notification notification){
    id = notification.getId();
    text = notification.getText();
    read = notification.isRead();
    route = notification.getRoute();
    createdAt = notification.getCreatedAt();
    updatedAt = notification.getUpdatedAt();
    status = notification.isStatus();
    userId = notification.getUser().getId();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    this.read = read;
  }

  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

}
