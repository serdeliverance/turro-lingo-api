package io.github.sd3v.mflashcardsbe.repository

import io.github.sd3v.mflashcardsbe.domain.CreateDeck
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity

interface DeckRepository {
    fun findFirstBySlug(slug: String): DeckEntity?

    fun findAll(): List<DeckEntity>

    fun save(deck: CreateDeck): DeckEntity
}
