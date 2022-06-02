package br.com.surb.surb.modules.role.dto;

import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import br.com.surb.surb.shared.enums.TypeStatus;

import java.io.Serializable;
import java.time.Instant;

public class RoleUpdateDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String authority;
  private TypeStatus status;
  private Instant createdAt;
  private Instant updatedAt;

  public RoleUpdateDTO(Long id, String authority, TypeStatus status, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.authority = authority;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public RoleUpdateDTO(Role role){
    id = role.getId();
    authority = role.getAuthority();
    status = role.getStatus();
    createdAt = role.getCreatedAt();
    updatedAt = role.getUpdatedAt();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public TypeStatus getStatus() {
    return status;
  }

  public void setStatus(TypeStatus status) {
    this.status = status;
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

}
