package br.com.surb.surb.modules.user.useCases.UserFindById;

import br.com.surb.surb.modules.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserFindByIdController {

  @Autowired
  private UserFindByIdService userFindByIdService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> handle(@PathVariable Long id) {
    UserDTO userDTO = userFindByIdService.execute(id);
    return ResponseEntity.ok().body(userDTO);
  }
}
