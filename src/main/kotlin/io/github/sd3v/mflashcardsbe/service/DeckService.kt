package io.github.sd3v.mflashcardsbe.service

import io.github.sd3v.mflashcardsbe.api.dto.NewFlashcardDto
import io.github.sd3v.mflashcardsbe.domain.CreateDeck
import io.github.sd3v.mflashcardsbe.domain.Deck
import io.github.sd3v.mflashcardsbe.domain.Flashcard
import io.github.sd3v.mflashcardsbe.repository.DeckRepository
import io.github.sd3v.mflashcardsbe.repository.FlashcardRepository
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity
import io.github.sd3v.mflashcardsbe.service.helpers.DeckMapper.toDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeckService(val deckRepository: DeckRepository, val flashcardRepository: FlashcardRepository) {

    private val logger = LoggerFactory.getLogger(DeckService::class.java)

    fun getAll(): List<Deck> {
        return deckRepository.findAll().map { buildDeckWithFlashcards(it) }
    }

    @Transactional
    fun create(deck: CreateDeck): Deck {
        val deckEntity = deckRepository.save(deck)
        val flashcardEntities = deck.flashcards.map {
            flashcardRepository.save(it, deckEntity.id)
        }
        return toDomain(deckEntity, flashcardEntities)
    }

    fun getBySlug(slug: String): Deck? =
        deckRepository.findFirstBySlug(slug)?.let { buildDeckWithFlashcards(it) }

    fun addFlashcards(deckId: Long, newFlashcardDto: NewFlashcardDto) {
        TODO("implement")
    }

    fun update(deck: Deck): Deck {
        TODO("implement")
    }

    private fun buildDeckWithFlashcards(entity: DeckEntity): Deck {
        logger.info("building entity: $entity")
        val flashcards = flashcardRepository.findAllByDeckId(entity.id).map { Flashcard(it.id, it.front, it.back) }
        val tags = entity.tags.split(",").map { it.trim() }
        return Deck(entity.id, entity.name, entity.slug, entity.description, entity.type, entity.language, flashcards, tags)
    }
}
