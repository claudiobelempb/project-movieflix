package br.com.surb.surb.modules.role.useCases.RoleFindById;

import br.com.surb.surb.modules.role.dto.RoleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleFindByIdController {

  private final RoleFindByIdService roleFindByIdService;

  public RoleFindByIdController(RoleFindByIdService roleFindByIdService){
    this.roleFindByIdService = roleFindByIdService;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<RoleDTO> handle(@PathVariable Long id) {
    RoleDTO roleDTO = roleFindByIdService.execute(id);
    return ResponseEntity.ok().body(roleDTO);
  }
}
