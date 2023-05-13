package io.github.sd3v.mflashcardsbe.service

import io.github.sd3v.mflashcardsbe.api.dto.NewFlashcardDto
import io.github.sd3v.mflashcardsbe.domain.CreateDeck
import io.github.sd3v.mflashcardsbe.domain.Deck
import io.github.sd3v.mflashcardsbe.repository.DeckRepository
import io.github.sd3v.mflashcardsbe.service.helpers.DeckMapper
import io.github.sd3v.mflashcardsbe.service.helpers.DeckMapper.toDomain
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeckService(val deckRepository: DeckRepository) {

    fun getAll(): List<Deck> {
        return deckRepository.findAll().map(DeckMapper::toDomain)
    }

    @Transactional
    fun create(deck: CreateDeck): Deck {
        val deckEntity = deckRepository.save(deck)
        return toDomain(deckEntity)
    }

    fun getBySlug(slug: String): Deck? =
        deckRepository.findFirstBySlug(slug)?.let { toDomain(it) }

    fun addFlashcards(deckId: Long, newFlashcardDto: NewFlashcardDto) {
        TODO("implement")
    }

    fun update(deck: Deck): Deck {
        TODO("implement")
    }
}
