package io.github.sd3v.mflashcardsbe.api

import io.github.sd3v.mflashcardsbe.service.FlashcardSetService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("flashcards")
class FlashcardSetController(val flashcardSetService: FlashcardSetService) {

    @GetMapping
    fun getAll() = flashcardSetService.getAll()
}