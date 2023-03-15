package io.github.sd3v.mflashcardsbe.api;

import io.github.sd3v.mflashcardsbe.api.dto.MenuItemDto;

import io.github.sd3v.mflashcardsbe.api.helpers.MenuItemMapper;
import io.github.sd3v.mflashcardsbe.service.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menus")
public class MenuController {


  private final DeckService deckService;

  @GetMapping
  public Flux<MenuItemDto> getAll() {
    return deckService.getAll().mapNotNull(MenuItemMapper::from);
  }
}
