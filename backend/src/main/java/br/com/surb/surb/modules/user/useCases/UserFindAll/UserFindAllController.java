package br.com.surb.surb.modules.user.useCases.UserFindAll;

import br.com.surb.surb.modules.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserFindAllController {

  @Autowired
  private UserFindAllService userFindAllService;

  @GetMapping
  public ResponseEntity<Page<UserDTO>> handle(Pageable pageable){
    /*PARAMETRISE: page, size, sort*/
    Page<UserDTO> userDTOS = userFindAllService.execute(pageable);
    return ResponseEntity.ok().body(userDTOS);
  }
}
