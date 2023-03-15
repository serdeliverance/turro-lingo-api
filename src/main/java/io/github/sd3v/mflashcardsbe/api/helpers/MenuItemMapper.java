package io.github.sd3v.mflashcardsbe.api.helpers;

import io.github.sd3v.mflashcardsbe.api.dto.MenuItemDto;
import io.github.sd3v.mflashcardsbe.domain.Deck;

public class MenuItemMapper {
  public static MenuItemDto from(Deck deck) {
    return new MenuItemDto(deck.id(), deck.name(), deck.slug());
  }
}
