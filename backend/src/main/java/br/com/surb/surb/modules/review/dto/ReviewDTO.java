package br.com.surb.surb.modules.review.dto;

import br.com.surb.surb.modules.review.infra.entities.Review;

import java.io.Serializable;

public class ReviewDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String text;

  public ReviewDTO(){}

  public ReviewDTO(Long id, String text) {
    this.id = id;
    this.text = text;
  }

  public ReviewDTO(Review review){
    id = review.getId();
    text = review.getText();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
