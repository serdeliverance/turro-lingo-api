package io.github.sd3v.mflashcardsbe.service.helpers;

import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import io.github.sd3v.mflashcardsbe.domain.Deck;
import io.github.sd3v.mflashcardsbe.domain.Flashcard;
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity;
import java.util.Arrays;
import java.util.List;

public class DeckMapper {

  public static DeckEntity toEntity(CreateDeck deck) {
    return new DeckEntity(
        1l, // TODO check
        deck.name(),
        deck.slug(),
        deck.description(),
        deck.type(),
        deck.language(),
        String.join(",", deck.tags()));
  }

  public static Deck toDomain(DeckEntity deck, List<FlashcardEntity> flashcards) {
    return new Deck(
        deck.id(),
        deck.name(),
        deck.slug(),
        deck.description(),
        deck.type(),
        deck.language(),
        flashcards.stream()
            .map(fce -> new Flashcard(fce.id(), fce.front(), fce.back(), fce.example()))
            .toList(),
        Arrays.stream(deck.tags().split(",")).toList());
  }
}
