package io.github.sd3v.mflashcardsbe.service;

import static io.github.sd3v.mflashcardsbe.service.helpers.DeckMapper.toDomain;
import static io.github.sd3v.mflashcardsbe.service.helpers.DeckMapper.toEntity;

import io.github.sd3v.mflashcardsbe.api.dto.NewFlashcardDto;
import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import io.github.sd3v.mflashcardsbe.domain.Deck;
import io.github.sd3v.mflashcardsbe.repository.DeckRepository;
import io.github.sd3v.mflashcardsbe.service.helpers.DeckMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeckService {
  private final DeckRepository deckRepository;

  public List<Deck> getAll() {
    return deckRepository.findAll().stream().map(DeckMapper::toDomain).toList();
  }

  public Deck create(CreateDeck deck) {
    var deckEntity = deckRepository.save(toEntity(deck));
    return toDomain(deckEntity);
  }

  public Optional<Deck> getBySlug(String slug) {
    return deckRepository.findFirstBySlug(slug).map(DeckMapper::toDomain);
  }

  public void addFlashcards(Integer deckId, NewFlashcardDto newFlashcardDto) {
    // TODO implement
  }

  public Deck update(Deck deck) {
    // TODO implement
    return null;
  }
}
