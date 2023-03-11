package io.github.sd3v.mflashcardsbe.api;

import io.github.sd3v.mflashcardsbe.api.dto.MenuItemDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/menus")
public class MenuController {

  @GetMapping
  public Flux<MenuItemDto> getAll() {
    return Flux.fromIterable(
        List.of(
            new MenuItemDto("1", "german 101", "german-101"),
            new MenuItemDto("2", "vocabulary", "dummy"),
            new MenuItemDto("3", "sayings", "sayings"),
            new MenuItemDto("4", "xxx", "xxx")));
  }
}
