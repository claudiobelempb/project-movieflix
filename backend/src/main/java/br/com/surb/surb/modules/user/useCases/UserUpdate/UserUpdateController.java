package br.com.surb.surb.modules.user.useCases.UserUpdate;

import br.com.surb.surb.modules.user.dto.UserDTO;
import br.com.surb.surb.modules.user.dto.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/users")
public class UserUpdateController {

  @Autowired
  private UserUpdateService userUpdateService;

  @PutMapping(value = "/{id}")
  public ResponseEntity<UserDTO> handle(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
    UserDTO userDTO = userUpdateService.execute(id, userUpdateDTO);
    return ResponseEntity.ok().body(userDTO);
  }
}
