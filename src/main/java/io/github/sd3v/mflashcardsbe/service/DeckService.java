package io.github.sd3v.mflashcardsbe.service;

import static io.github.sd3v.mflashcardsbe.service.helpers.DeckMapper.toEntity;

import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import io.github.sd3v.mflashcardsbe.domain.Deck;
import io.github.sd3v.mflashcardsbe.repository.DeckRepository;
import io.github.sd3v.mflashcardsbe.service.helpers.DeckMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeckService {
  private final DeckRepository deckRepository;

  public Mono<Deck> create(CreateDeck deck) {
    return deckRepository.save(toEntity(deck)).mapNotNull(DeckMapper::toDomain);
  }
}
