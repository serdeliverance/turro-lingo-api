package io.github.sd3v.mflashcardsbe.api.helpers;

import io.github.sd3v.mflashcardsbe.api.dto.FlashcardDto;
import io.github.sd3v.mflashcardsbe.domain.Flashcard;

public class FlashcardMapper {
  public static Flashcard toDomain(FlashcardDto dto) {
    return new Flashcard(String.valueOf(dto.id()), dto.front(), dto.back());
  }

  public static FlashcardDto toDto(Flashcard flashcard) {
    return new FlashcardDto(Integer.valueOf(flashcard.id()), flashcard.front(), flashcard.back());
  }
}
