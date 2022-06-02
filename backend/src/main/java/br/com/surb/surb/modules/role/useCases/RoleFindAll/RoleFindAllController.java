package br.com.surb.surb.modules.role.useCases.RoleFindAll;

import br.com.surb.surb.modules.role.dto.RoleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleFindAllController {

  private final RoleFindAllService roleFindAllService;

  public RoleFindAllController(RoleFindAllService roleFindAllService){
    this.roleFindAllService = roleFindAllService;
  }

  @GetMapping
  public ResponseEntity<Page<RoleDTO>> handle(Pageable pageable) {
    /*PARAMETRISE: page, size, sort*/
    Page<RoleDTO> roleDTOS = roleFindAllService.execute(pageable);
    return ResponseEntity.ok().body(roleDTOS);
  }
}
