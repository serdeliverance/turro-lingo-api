package io.github.sd3v.mflashcardsbe.repository

import io.github.sd3v.mflashcardsbe.domain.CreateFlashcard
import io.github.sd3v.mflashcardsbe.jooq.Tables
import io.github.sd3v.mflashcardsbe.jooq.tables.Flashcard.FLASHCARD
import io.github.sd3v.mflashcardsbe.jooq.tables.pojos.Flashcard
import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity
import org.jooq.DSLContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class FlashcardRepositoryImpl(val create: DSLContext) : FlashcardRepository {

    private val logger = LoggerFactory.getLogger(FlashcardRepositoryImpl::class.java)

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

    override fun save(flashcard: CreateFlashcard, deckId: Long): FlashcardEntity {
        logger.info("Saving flashcard: {}", flashcard)

        val newFlashcard = create.newRecord(Tables.FLASHCARD)
        newFlashcard.front = flashcard.front
        newFlashcard.back = flashcard.back
        newFlashcard.deckId = deckId
        // TODO return just id (to optimize data transfer) and create DeckEntity with the values we already have
        return create.insertInto(Tables.FLASHCARD).set(newFlashcard).returning().fetchOne {
                r ->
            FlashcardEntity(r.id, r.front, r.back, r.deckId)
        }!!
    }
}
