package io.github.sd3v.mflashcardsbe.api.helpers;

import io.github.sd3v.mflashcardsbe.api.dto.FlashcardDto;
import io.github.sd3v.mflashcardsbe.domain.Flashcard;

public class FlashcardMapper {
  public static Flashcard toDomain(FlashcardDto dto) {
    return new Flashcard(dto.id(), dto.front(), dto.back(), dto.example());
  }

  public static FlashcardDto toDto(Flashcard flashcard) {
    return new FlashcardDto(
        flashcard.id(), flashcard.front(), flashcard.back(), flashcard.example());
  }
}
