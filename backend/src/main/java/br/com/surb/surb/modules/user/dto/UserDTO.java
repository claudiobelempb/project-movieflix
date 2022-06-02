package br.com.surb.surb.modules.user.dto;

import static br.com.surb.surb.shared.constants.AppMessageConstants.REQUIRED_EMAIL;
import static br.com.surb.surb.shared.constants.AppMessageConstants.REQUIRED_FIELD;

import br.com.surb.surb.modules.role.dto.RoleDTO;
import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.shared.enums.TypeStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  @NotBlank(message = REQUIRED_FIELD)
  private String firstName;
  private String lastName;

  @Email(message = REQUIRED_EMAIL)
  private String email;
  private Instant createdAt;
  private Instant updatedAt;
  private TypeStatus status;

  private final Set<RoleDTO> roles = new HashSet<>();

  public UserDTO(){}

  public UserDTO(Long id, String firstName, String lastName, String email, Instant createdAt,
                 Instant updatedAt,
                 TypeStatus status) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }

  public UserDTO(User user){
    id = user.getId();
    firstName = user.getFirstName();
    lastName = user.getLastName();
    email = user.getEmail();
    createdAt = user.getCreatedAt();
    updatedAt = user.getUpdatedAt();
    status = user.getStatus();
    user.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
  }

//  public UserDTO(User user, Set<Role> roles) {
//    this(user);
//    roles.forEach(role -> this.roles.add(new RoleDTO(role)));
//  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public TypeStatus getStatus() {
    return status;
  }

  public void setStatus(TypeStatus status) {
    this.status = status;
  }

  public Set<RoleDTO> getRoles() {
    return roles;
  }
}
