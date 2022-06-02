package br.com.surb.surb.modules.genre.infra.entities;

import br.com.surb.surb.modules.movie.infra.jpa.entities.Movie;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_genre")
public class Genre implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "genre")
  private final List<Movie> movies = new ArrayList<>();

  public Genre(){}

  public Genre(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Movie> getMovies() {
    return movies;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Genre genre = (Genre) o;
    return id.equals(genre.id) && name.equals(genre.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
