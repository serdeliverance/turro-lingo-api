package io.github.sd3v.mflashcardsbe.api

import io.github.sd3v.mflashcardsbe.api.dto.MenuItemDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/menus")
class MenuController {

    @GetMapping
    fun getAll(): Flux<MenuItemDto> = Flux.fromArray(
        arrayOf(
            MenuItemDto("1", "german 101"),
            MenuItemDto("2", "vocabulary"),
            MenuItemDto("3", "sayings"),
            MenuItemDto("4", "xxx"),
        ),
    )
}
