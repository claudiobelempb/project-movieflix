package br.com.surb.surb.modules.role.infra.jpa.repositories;

import br.com.surb.surb.modules.role.infra.jpa.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
