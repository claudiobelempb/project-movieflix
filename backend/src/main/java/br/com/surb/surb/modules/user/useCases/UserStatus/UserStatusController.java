package br.com.surb.surb.modules.user.useCases.UserStatus;

import br.com.surb.surb.modules.user.dto.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserStatusController {

  @Autowired
  private UserStatusService userStatusService;

  @PatchMapping(value = "/status/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
    userStatusService.execute(id, userUpdateDTO);
    return ResponseEntity.noContent().build();
  }
}
