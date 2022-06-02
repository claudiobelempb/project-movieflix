package br.com.surb.surb.shared.exeptions.services;

import java.io.Serializable;

public class AppUnauthorizedException extends RuntimeException implements Serializable {

  private static final long serialVersionUID = 1L;

  public AppUnauthorizedException(String msg) {
    super(msg);
  }
}
