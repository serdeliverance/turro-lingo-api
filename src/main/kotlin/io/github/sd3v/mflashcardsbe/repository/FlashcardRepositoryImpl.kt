package io.github.sd3v.mflashcardsbe.repository

import io.github.sd3v.mflashcardsbe.jooq.tables.Flashcard.FLASHCARD
import io.github.sd3v.mflashcardsbe.jooq.tables.pojos.Flashcard
import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class FlashcardRepositoryImpl(val create: DSLContext) : FlashcardRepository {

    override fun findById(id: Long): FlashcardEntity? =
        create.select().from(FLASHCARD)
            .where(FLASHCARD.ID.equal(id))
            .fetchOne()
            ?.into(Flashcard::class.java)
            ?.let { FlashcardEntity(it.id, it.front, it.back, it.deckId) }

    override fun findAllByDeckId(deckId: Long): List<FlashcardEntity> =
        create.select().from(FLASHCARD)
            .where(FLASHCARD.DECK_ID.equal(deckId))
            .fetch()
            .into(Flashcard::class.java)
            .map { FlashcardEntity(it.id, it.front, it.back, it.deckId) }
}
