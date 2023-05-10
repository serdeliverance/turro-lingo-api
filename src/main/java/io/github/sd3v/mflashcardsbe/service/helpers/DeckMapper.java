package io.github.sd3v.mflashcardsbe.service.helpers;

import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import io.github.sd3v.mflashcardsbe.domain.Deck;
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DeckMapper {

  public static DeckEntity toEntity(CreateDeck deck) {
    return new DeckEntity(
        null,
        deck.name(),
        deck.slug(),
        deck.description(),
        deck.type(),
        deck.language(),
        deck.tags().stream().collect(Collectors.joining(",")));
  }

  public static Deck toDomain(DeckEntity entity) {
    return new Deck(
        entity.id(),
        entity.name(),
        entity.slug(),
        entity.description(),
        entity.type(),
        entity.language(),
        null,
        Arrays.stream(entity.tags().split(",")).toList());
  }
}
