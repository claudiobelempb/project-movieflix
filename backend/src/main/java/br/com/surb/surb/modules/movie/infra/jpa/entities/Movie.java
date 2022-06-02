package br.com.surb.surb.modules.movie.infra.jpa.entities;


import br.com.surb.surb.modules.genre.infra.entities.Genre;
import br.com.surb.surb.modules.review.infra.entities.Review;
import br.com.surb.surb.shared.enums.TypeStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;


@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String subTitle;
  private Integer year;
  @Column(columnDefinition = "TEXT")
  private String synopsis;
  private String imgUrl;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  private TypeStatus status;

  @OneToMany(mappedBy = "movie")
  private final List<Review> reviews = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "genre_id")
  private  Genre genre;

  public Movie(){}

  public Movie(Long id, String title, String subTitle, Integer year, String synopsis, String imgUrl, Instant createdAt,
               Instant updatedAt,
               TypeStatus status) {
    this.id = id;
    this.title = title;
    this.subTitle = subTitle;
    this.synopsis = synopsis;
    this.imgUrl = imgUrl;
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

  public List<Review> getReviews() {
    return reviews;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
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

  @PrePersist
  public void prePersist(){
    createdAt = Instant.now();
    status = TypeStatus.ENABLED;
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Movie movie = (Movie) o;
    return id.equals(movie.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
