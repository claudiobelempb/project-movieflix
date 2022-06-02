package br.com.surb.surb.shared.exeptions.services;

import java.io.Serializable;

public class AppDataBaseException extends RuntimeException implements Serializable {
  private static final long serialVersionUID = 1L;

  public AppDataBaseException(String message) {
    super(message);
  }
}
