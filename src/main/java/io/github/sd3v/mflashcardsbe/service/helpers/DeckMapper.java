package io.github.sd3v.mflashcardsbe.service.helpers;

import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import io.github.sd3v.mflashcardsbe.domain.Deck;
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import java.util.Arrays;

public class DeckMapper {

  public static DeckEntity toEntity(CreateDeck deck) {
    return new DeckEntity(
        1, // TODO check
        deck.name(),
        deck.slug(),
        deck.description(),
        deck.type(),
        deck.language(),
        String.join(",", deck.tags()));
  }

  public static Deck toDomain(DeckEntity entity) {
    return new Deck(
        entity.getId(),
        entity.getName(),
        entity.getSlug(),
        entity.getDescription(),
        entity.getType(),
        entity.getLanguage(),
        null,
        Arrays.stream(entity.getTags().split(",")).toList());
  }
}
