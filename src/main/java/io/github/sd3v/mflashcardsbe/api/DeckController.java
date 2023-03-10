package io.github.sd3v.mflashcardsbe.api;

import io.github.sd3v.mflashcardsbe.api.dto.DeckDto;
import io.github.sd3v.mflashcardsbe.api.dto.FlashcardDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/decks")
public class DeckController {

  @GetMapping("/{id}")
  public Mono<DeckDto> getById(@PathVariable String id) {
    // TODO implement
    return null;
  }

  @GetMapping("/slug/{slug}")
  public Mono<DeckDto> getBySlug(@PathVariable String slug) {
    return Mono.just(
        new DeckDto(
            slug,
            "something",
            "phrases",
            "de_DE",
            List.of(new FlashcardDto(1, "Du bist eine Zitrone", "You are a lemon", null, null)),
            List.of()));
  }
}
