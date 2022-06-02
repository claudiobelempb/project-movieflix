package br.com.surb.surb.modules.user.infra.jpa.entities;

import br.com.surb.surb.modules.notification.infra.entities.Notification;
import br.com.surb.surb.modules.review.infra.entities.Review;
import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import br.com.surb.surb.shared.enums.TypeStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails, Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;

  private String lastName;

  @Column(unique = true)
  private String email;

  private String password;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  private TypeStatus status;

  /*Obj dessa form vem junto uma list de roles
  * associação muitos para muitos com a tb_role
  * usar sempre o set<>
  */
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "tb_user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private final Set<Role> roles = new HashSet<>();

  @OneToMany(mappedBy = "user")
  private final List<Notification> notifications = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private final List<Review> reviews = new ArrayList<>();

  public User(){}

  public User(Long id, String firstName, String lastName, String email, String password, Instant createdAt,
              Instant updatedAt,
              TypeStatus status) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }

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

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public Set<Role> getRoles() {
    return roles;
  }

  public List<Notification> getNotifications() {
    return notifications;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  @PrePersist
  public void prePersist(){
    createdAt = Instant.now();
    status = TypeStatus.ENABLED;
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles
      .stream()
      .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
      .collect(Collectors.toList());
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id.equals(user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public boolean hasRole(String roleName){
    for(Role role: roles){
      if(role.getAuthority().equals(roleName)){
        return true;
      }
    }
    return false;
  }

}
