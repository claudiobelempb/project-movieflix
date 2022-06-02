package br.com.surb.surb.modules.role.useCases.RoleCreate;

import br.com.surb.surb.modules.role.dto.RoleCreateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleCreateController {

  private final RoleCreateService roleCreateService;

  public RoleCreateController(RoleCreateService roleCreateService){
    this.roleCreateService = roleCreateService;
  }

  @PostMapping
  public ResponseEntity<RoleCreateDTO> handle(@RequestBody RoleCreateDTO roleCreateDTO) {
    roleCreateDTO = roleCreateService.execute(roleCreateDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(roleCreateDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(roleCreateDTO);
  }
}
