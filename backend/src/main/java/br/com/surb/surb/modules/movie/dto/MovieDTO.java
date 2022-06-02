package br.com.surb.surb.modules.movie.dto;

import br.com.surb.surb.modules.movie.infra.jpa.entities.Movie;
import br.com.surb.surb.shared.enums.TypeStatus;
import java.io.Serializable;
import java.time.Instant;

public class MovieDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String title;
  private String subTitle;
  private Integer year;
  private String synopsis;
  private String imgUrl;
  private Instant createdAt;
  private Instant updatedAt;
  private TypeStatus status;

  public MovieDTO(){}

  public MovieDTO(Long id, String title, String subTitle, Integer year, String synopsis, String imgUrl,
                  Instant createdAt,
                  Instant updatedAt, TypeStatus status) {
    this.id = id;
    this.title = title;
    this.subTitle = subTitle;
    this.year = year;
    this.synopsis = synopsis;
    this.imgUrl = imgUrl;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }

  public MovieDTO(Movie movie){
    id = movie.getId();
    title = movie.getTitle();
    subTitle = movie.getSubTitle();
    year = movie.getYear();
    synopsis = getSynopsis();
    imgUrl = movie.getImgUrl();
    createdAt = movie.getCreatedAt();
    updatedAt = movie.getUpdatedAt();
    status = movie.getStatus();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public TypeStatus getStatus() {
    return status;
  }

  public void setStatus(TypeStatus status) {
    this.status = status;
  }

}
