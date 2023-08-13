package io.github.sd3v.mflashcardsbe.api;

import io.github.sd3v.mflashcardsbe.api.dto.CreateDeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.DeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.FlashcardDto;
import io.github.sd3v.mflashcardsbe.api.dto.NewFlashcardDto;
import io.github.sd3v.mflashcardsbe.api.exceptions.EntityNotFoundException;
import io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper;
import io.github.sd3v.mflashcardsbe.domain.Deck;
import io.github.sd3v.mflashcardsbe.service.DeckService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

  private final DeckService deckService;

  private static Logger logger = LoggerFactory.getLogger(DeckController.class);

  @GetMapping
  public List<DeckDto> getAll() {
    return deckService.getAll().stream().map(DeckMapper::toDto).toList();
  }

  @GetMapping("/{id}")
  public DeckDto getById(@PathVariable Long id) {
    logger.info("Getting deck with id: {}", id);
    return deckService
        .getById(id)
        .map(DeckMapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException("deck", "id", id.toString()));
  }

  @GetMapping("/slug/{slug}")
  public DeckDto getBySlug(@PathVariable String slug) {
    return deckService
        .getBySlug(slug)
        .map(DeckMapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException("deck", "slug", slug));
  }

  @PostMapping
  public DeckDto create(@RequestBody CreateDeckDto createDeckDto) {
    logger.info("Creating deck...");
    Deck createdDeck = deckService.create(DeckMapper.toDomain(createDeckDto));
    return DeckMapper.toDto(createdDeck);
  }

  @PostMapping("/{id}/flashcards")
  public void addFlashcard(
      @PathVariable("id") Long deckId, @RequestBody NewFlashcardDto newFlashcardDto) {
    deckService.addFlashcard(deckId, newFlashcardDto);
  }

  @DeleteMapping("/{deckId}/flashcards/{flashcardId}")
  public FlashcardDto deleteFlashcards(
      @PathVariable("deckId") int deckId, @PathVariable("flashcardId") String flashcardId) {
    return null;
  }
}
