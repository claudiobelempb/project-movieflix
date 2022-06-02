package br.com.surb.surb.shared.exeptions.resources;

import java.util.ArrayList;
import java.util.List;

public class AppValidationErrorApp extends AppStandarError {

  private static final long serialVersionUID = 1L;

  private final List<AppFieldMessage> errors = new ArrayList<>();

  public List<AppFieldMessage> getErrors() {
    return errors;
  }

  public void addError(String fieldName, String message) {
    errors.add(new AppFieldMessage(fieldName, message));
  }

}