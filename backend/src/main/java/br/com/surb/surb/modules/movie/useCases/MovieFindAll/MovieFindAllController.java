package br.com.surb.surb.modules.movie.useCases.MovieFindAll;

import br.com.surb.surb.modules.movie.dto.MovieDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/movies")
public class MovieFindAllController {

  private final MovieFindAllService movieFindAllService;

  public MovieFindAllController(MovieFindAllService movieFindAllService){
    this.movieFindAllService = movieFindAllService;
  }

  @GetMapping
  public ResponseEntity<Page<MovieDTO>> handle(Pageable pageable)
  {
    /*PARAMETRISE: page, size, sort*/
    Page<MovieDTO> dto = movieFindAllService.execute(pageable);
    return ResponseEntity.ok().body(dto);
  }
}
