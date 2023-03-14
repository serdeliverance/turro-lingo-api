package io.github.sd3v.mflashcardsbe.api;

import static io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper.toDomain;

import io.github.sd3v.mflashcardsbe.api.dto.CreateDeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.DeckDto;
import io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper;
import io.github.sd3v.mflashcardsbe.service.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

  private final DeckService deckService;

  @GetMapping("/{id}")
  public Mono<DeckDto> getById(@PathVariable String id) {
    // TODO implement
    return null;
  }

  @GetMapping("/slug/{slug}")
  public Mono<DeckDto> getBySlug(@PathVariable String slug) {
    return deckService.getBySlug(slug).map(DeckMapper::toDto);
  }

  @PostMapping("/")
  public Mono<DeckDto> create(@RequestBody CreateDeckDto createDeckDto) {
    return deckService.create(toDomain(createDeckDto)).map(DeckMapper::toDto);
  }
}
