package br.com.surb.surb.modules.movie.useCases.MovieFindById;

import br.com.surb.surb.modules.movie.dto.MovieDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/movies")
public class MovieFindByIdController {

  private final MovieFindByIdService movieFindByIdService;

  public MovieFindByIdController(MovieFindByIdService movieFindByIdService){
    this.movieFindByIdService = movieFindByIdService;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<MovieDTO> handle(@PathVariable Long id){
    MovieDTO dto = movieFindByIdService.execute(id);
    return ResponseEntity.ok().body(dto);
  }
}
