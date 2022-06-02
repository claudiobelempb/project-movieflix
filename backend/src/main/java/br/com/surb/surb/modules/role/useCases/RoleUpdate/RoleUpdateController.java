package br.com.surb.surb.modules.role.useCases.RoleUpdate;

import br.com.surb.surb.modules.role.dto.RoleUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleUpdateController {

  private final RoleUpdateService roleUpdateService;

  public RoleUpdateController(RoleUpdateService roleUpdateService) {
    this.roleUpdateService = roleUpdateService;
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<RoleUpdateDTO> handle(@PathVariable Long id, @RequestBody RoleUpdateDTO roleUpdateDTO) {
    roleUpdateDTO = roleUpdateService.execute(id, roleUpdateDTO);
    return ResponseEntity.ok().body(roleUpdateDTO);
  }
}
