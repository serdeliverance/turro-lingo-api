package io.github.sd3v.mflashcardsbe.service;

import io.github.sd3v.mflashcardsbe.domain.Deck;
import io.github.sd3v.mflashcardsbe.domain.Flashcard;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MaintenanceService {

  private final DeckService deckService;

  public void addIdToFlashcards() {
    deckService.getAll().stream()
        .filter(deck -> deck.name().equals("example")) // just for development, delete later
        .map(
            deck -> {
              var flashcards =
                  deck.flashcards().stream()
                      .map(f -> new Flashcard(UUID.randomUUID().toString(), f.front(), f.back()))
                      .toList();
              return new Deck(
                  deck.id(),
                  deck.name(),
                  deck.slug(),
                  deck.description(),
                  deck.type(),
                  deck.language(),
                  flashcards,
                  deck.tags());
            })
        .forEach(deckService::update);
  }
}
