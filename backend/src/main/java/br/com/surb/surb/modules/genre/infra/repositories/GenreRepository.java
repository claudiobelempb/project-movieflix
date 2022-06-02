package br.com.surb.surb.modules.genre.infra.repositories;

import br.com.surb.surb.modules.genre.infra.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
