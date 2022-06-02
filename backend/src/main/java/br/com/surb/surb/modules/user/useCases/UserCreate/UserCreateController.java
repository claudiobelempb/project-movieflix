package br.com.surb.surb.modules.user.useCases.UserCreate;

import br.com.surb.surb.modules.user.dto.UserCreateDTO;
import br.com.surb.surb.modules.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/users")
public class UserCreateController {

  private final UserCreateService userCreateService;

  public UserCreateController (UserCreateService userCreateService){
    this.userCreateService = userCreateService;
  }

  @PostMapping
  public ResponseEntity<UserDTO> handle(@Valid @RequestBody UserCreateDTO userCreateDTO) {
    UserDTO userDTO = userCreateService.execute(userCreateDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(userDTO);
  }
}
