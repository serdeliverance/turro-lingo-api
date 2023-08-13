package io.github.sd3v.mflashcardsbe.api.helpers;

import io.github.sd3v.mflashcardsbe.api.dto.MenuItemDto;
import io.github.sd3v.mflashcardsbe.domain.MenuItem;

public class MenuItemMapper {
  public static MenuItemDto toDto(MenuItem domain) {
    return new MenuItemDto(domain.id(), domain.name(), domain.slug());
  }
}
