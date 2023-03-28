package io.github.sd3v.mflashcardsbe.api.exceptions;

public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException(String entity, String attributeName, String value) {
    super(String.format("Not found %s with attribute %s = %s", entity, attributeName, value));
  }
}
