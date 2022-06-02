package br.com.surb.surb.modules.role.useCases.RoleStatus;

import br.com.surb.surb.modules.role.dto.RoleUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleStatusController {

  private final RoleStatusService roleStatusService;

  public RoleStatusController(RoleStatusService roleStatusService) {
    this.roleStatusService = roleStatusService;
  }

  @PatchMapping(value = "/status/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody RoleUpdateDTO roleUpdateDTO){
    roleStatusService.execute(id, roleUpdateDTO);
    return ResponseEntity.noContent().build();
  }
}
