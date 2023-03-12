package io.github.sd3v.mflashcardsbe.api.helpers;

import io.github.sd3v.mflashcardsbe.api.dto.CreateDeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.DeckDto;
import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import io.github.sd3v.mflashcardsbe.domain.Deck;

public class DeckMapper {

  public static CreateDeck toDomain(CreateDeckDto dto) {
    return new CreateDeck(
        dto.name(),
        dto.slug(),
        dto.description(),
        dto.type(),
        dto.language(),
        dto.flashcards().stream().map(FlashcardMapper::toDomain).toList(),
        dto.tags());
  }

  public static DeckDto toDto(Deck deck) {
    return new DeckDto(
        deck.id(),
        deck.name(),
        deck.slug(),
        deck.description(),
        deck.type(),
        deck.language(),
        deck.flashcards().stream().map(FlashcardMapper::toDto).toList(),
        deck.tags());
  }
}
