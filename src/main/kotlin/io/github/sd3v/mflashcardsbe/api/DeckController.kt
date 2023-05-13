package io.github.sd3v.mflashcardsbe.io.github.sd3v.mflashcardsbe.api

import io.github.sd3v.mflashcardsbe.api.dto.CreateDeckDto
import io.github.sd3v.mflashcardsbe.api.dto.DeckDto
import io.github.sd3v.mflashcardsbe.api.dto.FlashcardDto
import io.github.sd3v.mflashcardsbe.api.dto.NewFlashcardDto
import io.github.sd3v.mflashcardsbe.api.exceptions.EntityNotFoundException
import io.github.sd3v.mflashcardsbe.api.helpers.DeckMapper
import io.github.sd3v.mflashcardsbe.domain.Deck
import io.github.sd3v.mflashcardsbe.service.DeckService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/decks")
class DeckController(val deckService: DeckService) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: String?): DeckDto? {
        // TODO implement
        return null
    }

    @GetMapping("/slug/{slug}")
    fun getBySlug(@PathVariable slug: String): DeckDto? {
        return deckService
            .getBySlug(slug)
            .let { deck: Deck? ->
                DeckMapper.toDto(
                    deck,
                )
            } ?: throw
            EntityNotFoundException(
                "deck",
                "slug",
                slug,
            )
    }

    @PostMapping("/")
    fun create(@RequestBody createDeckDto: CreateDeckDto): DeckDto {
        val createdDeck = deckService.create(DeckMapper.toDomain(createDeckDto))
        return DeckMapper.toDto(createdDeck)
    }

    @PostMapping("/{id}/flashcards")
    fun addFlashcards(
        @PathVariable("id") deckId: Long,
        @RequestBody newFlashcardDto: NewFlashcardDto,
    ) {
        deckService.addFlashcards(deckId, newFlashcardDto)
    }

    @DeleteMapping("/{deckId}/flashcards/{flashcardId}")
    fun deleteFlashcard(
        @PathVariable("deckId") deckId: Int,
        @PathVariable("flashcardId") flashcardId: String,
    ): FlashcardDto? {
        // TODO implement
        return null
    }
}
