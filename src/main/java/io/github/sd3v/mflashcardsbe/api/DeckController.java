package io.github.sd3v.mflashcardsbe.api;

import io.github.sd3v.mflashcardsbe.api.dto.CreateDeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.DeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.FlashcardDto;
import java.util.List;

import io.github.sd3v.mflashcardsbe.service.DeckService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper.toDomain;

@RestController
@RequestMapping("/decks")
public class DeckController {

  private DeckService deckService;

  @GetMapping("/{id}")
  public Mono<DeckDto> getById(@PathVariable String id) {
    // TODO implement
    return null;
  }

  @GetMapping("/slug/{slug}")
  public Mono<DeckDto> getBySlug(@PathVariable String slug) {
    return Mono.just(
        new DeckDto(
            "German 101",
            slug,
            "something",
            "phrases",
            "de_DE",
            List.of(new FlashcardDto(1, "Du bist eine Zitrone", "You are a lemon", null, null)),
            List.of()));
  }

  @PostMapping("/")
  public Mono<Void> create(@RequestBody CreateDeckDto createDeckDto) {
    return deckService.create(toDomain(createDeckDto));
  }
}
