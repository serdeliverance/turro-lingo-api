package io.github.sd3v.mflashcardsbe.service;

import io.github.sd3v.mflashcardsbe.api.dto.NewFlashcardDto;
import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import io.github.sd3v.mflashcardsbe.domain.Deck;
import io.github.sd3v.mflashcardsbe.domain.Flashcard;
import io.github.sd3v.mflashcardsbe.repository.DeckRepository;
import io.github.sd3v.mflashcardsbe.repository.FlashcardRepository;
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import io.github.sd3v.mflashcardsbe.service.helpers.DeckMapper;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeckService {

  private final DeckRepository deckRepository;
  private final FlashcardRepository flashcardRepository;

  private static final Logger logger = LoggerFactory.getLogger(DeckService.class);

  public Optional<Deck> getById(Long id) {
    return deckRepository.findById(id).map(this::buildDeckWithFlashcards);
  }

  public Optional<Deck> getBySlug(String slug) {
    return deckRepository.findFirstBySlug(slug).map(this::buildDeckWithFlashcards);
  }

  @Transactional
  public Deck create(CreateDeck createDeck) {
    var deckEntity = deckRepository.save(createDeck);
    var flashcardEntityList =
        createDeck.flashcards().stream()
            .map(flashcard -> flashcardRepository.save(flashcard, deckEntity.id()))
            .toList();
    return DeckMapper.toDomain(deckEntity, flashcardEntityList);
  }

  // TODO implement
  public void addFlashcards(Long deckId, NewFlashcardDto newFlashcardDto) {}

  private Deck buildDeckWithFlashcards(DeckEntity entity) {
    logger.info("building entity: {}", entity);
    var flashcardList =
        flashcardRepository.findAllByDeckId(entity.id()).stream()
            .map(
                flashcard ->
                    new Flashcard(
                        flashcard.id(), flashcard.front(), flashcard.back(), flashcard.example()))
            .toList();
    var tags = Arrays.stream(entity.tags().split(",")).map(String::trim).toList();
    return new Deck(
        entity.id(),
        entity.name(),
        entity.slug(),
        entity.description(),
        entity.type(),
        entity.language(),
        flashcardList,
        tags);
  }

  public List<Deck> getAll() {
    return deckRepository.getAll().stream().map(this::buildDeckWithFlashcards).toList();
  }

  public void update(Deck deck) {
    // TODO implement
  }
}
