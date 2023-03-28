package io.github.sd3v.mflashcardsbe.api;

import static io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper.toDomain;
import static io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper.toDto;

import io.github.sd3v.mflashcardsbe.api.dto.CreateDeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.DeckDto;
import io.github.sd3v.mflashcardsbe.api.exceptions.EntityNotFoundException;
import io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper;
import io.github.sd3v.mflashcardsbe.service.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

  private final DeckService deckService;

  @GetMapping("/{id}")
  public DeckDto getById(@PathVariable String id) {
    // TODO implement
    return null;
  }

  @GetMapping("/slug/{slug}")
  public DeckDto getBySlug(@PathVariable String slug) {
    return deckService
        .getBySlug(slug)
        .map(DeckMapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException("deck", "slug", slug));
  }

  @PostMapping("/")
  public DeckDto create(@RequestBody CreateDeckDto createDeckDto) {
    var createdDeck = deckService.create(toDomain(createDeckDto));
    return toDto(createdDeck);
  }
}
