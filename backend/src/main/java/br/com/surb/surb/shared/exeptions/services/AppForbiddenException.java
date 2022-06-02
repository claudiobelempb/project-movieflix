package br.com.surb.surb.shared.exeptions.services;

import java.io.Serializable;

public class AppForbiddenException extends RuntimeException implements Serializable {

  private static final long serialVersionUID = 1L;

  public AppForbiddenException(String msg){
    super(msg);
  }
}
