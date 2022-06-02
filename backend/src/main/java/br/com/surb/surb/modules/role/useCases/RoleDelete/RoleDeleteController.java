package br.com.surb.surb.modules.role.useCases.RoleDelete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleDeleteController {

  private final RoleDeleteService roleDeleteService;

  public RoleDeleteController(RoleDeleteService roleDeleteService){
    this.roleDeleteService = roleDeleteService;
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id) {
    roleDeleteService.execute(id);
    return ResponseEntity.noContent().build();
  }
}
