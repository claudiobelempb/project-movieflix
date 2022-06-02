package br.com.surb.surb.shared.validator;

import org.springframework.data.util.Streamable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidationErrors implements Streamable<ValidationError> {

  private final List<ValidationError> validationErrors;

  public ValidationErrors() {
    this.validationErrors = new ArrayList<>();
  }

  public ValidationErrors addErrors(String field, String errorCode) {
    return addErrors(new ValidationError(field, errorCode));
  }

  public ValidationErrors addErrors(ValidationError validationError) {
    validationErrors.add(validationError);
    return this;
  }

  public ValidationError getErrorIndex(int index) {
    return validationErrors.get(index);
  }

  public int getErrorOfNumber() {
    return validationErrors.size();
  }

  public boolean hasErrors(){
    return !validationErrors.isEmpty();
  }

  @Override
  public String toString() {
    return "ValidationErrors{" +
      "validationErrors=" + validationErrors +
      '}';
  }

  @Override
  public Iterator<ValidationError> iterator() {
    return validationErrors.iterator();
  }
}
