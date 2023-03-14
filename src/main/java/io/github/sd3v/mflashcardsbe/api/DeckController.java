package io.github.sd3v.mflashcardsbe.api;

import static io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper.toDomain;

import io.github.sd3v.mflashcardsbe.api.dto.CreateDeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.DeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.FlashcardDto;
import io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper;
import io.github.sd3v.mflashcardsbe.service.DeckService;
import java.util.List;
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
    return Mono.just(
        new DeckDto(
            "1",
            "German 101",
            slug,
            "something",
            "phrases",
            "de_DE",
            List.of(new FlashcardDto(1, "Du bist eine Zitrone", "You are a lemon")),
            List.of()));
  }

  @PostMapping("/")
  public Mono<DeckDto> create(@RequestBody CreateDeckDto createDeckDto) {
    return deckService.create(toDomain(createDeckDto)).map(DeckMapper::toDto);
  }
}
