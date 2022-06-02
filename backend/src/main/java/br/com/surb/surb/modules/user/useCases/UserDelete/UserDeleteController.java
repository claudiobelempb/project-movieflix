package br.com.surb.surb.modules.user.useCases.UserDelete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserDeleteController {

  @Autowired
  private UserDeleteService userDeleteService;

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id){
    userDeleteService.execute(id);
    return ResponseEntity.noContent().build();
  }
}
