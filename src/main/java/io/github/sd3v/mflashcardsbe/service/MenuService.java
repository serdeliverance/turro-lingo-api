package io.github.sd3v.mflashcardsbe.service;

import io.github.sd3v.mflashcardsbe.domain.MenuItem;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

  private final DeckService deckService;

  public List<MenuItem> getAll() {
    return deckService.getAll().stream()
        .map(deck -> new MenuItem(deck.id(), deck.name(), deck.slug()))
        .toList();
  }
}
