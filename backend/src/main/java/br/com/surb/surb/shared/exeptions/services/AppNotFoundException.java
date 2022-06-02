package br.com.surb.surb.shared.exeptions.services;

import java.io.Serializable;

public class AppNotFoundException extends RuntimeException implements Serializable {
  private static final long serialVersionUID = 1L;

  public AppNotFoundException(String message) {
    super(message);
  }
}
