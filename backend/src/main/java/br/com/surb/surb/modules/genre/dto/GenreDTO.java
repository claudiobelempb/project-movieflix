package br.com.surb.surb.modules.genre.dto;

import br.com.surb.surb.modules.genre.infra.entities.Genre;

import java.io.Serializable;

public class GenreDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;

  public GenreDTO(){}

  public GenreDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public GenreDTO(Genre genre){
    id = genre.getId();
    name = genre.getName();
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

}