package io.github.sd3v.mflashcardsbe.service.helpers;

import io.github.sd3v.mflashcardsbe.domain.Flashcard;
import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity;

public class FlashcardMapper {
  public static FlashcardEntity toEntity(Flashcard domain) {
    // FIXME passing null here
    return new FlashcardEntity(
        domain.id(), domain.front(), domain.back(), 1); // TODO check hardcoded deck id
  }

  public static Flashcard toDomain(FlashcardEntity entity) {
    return new Flashcard(entity.getId(), entity.getFront(), entity.getBack());
  }
}
