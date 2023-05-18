package io.github.sd3v.mflashcardsbe.repository

import io.github.sd3v.mflashcardsbe.domain.CreateFlashcard
import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity

interface FlashcardRepository {

    fun findById(id: Long): FlashcardEntity?
    fun findAllByDeckId(deckId: Long): List<FlashcardEntity>
    fun save(flashcard: CreateFlashcard, deckId: Long): FlashcardEntity
}
