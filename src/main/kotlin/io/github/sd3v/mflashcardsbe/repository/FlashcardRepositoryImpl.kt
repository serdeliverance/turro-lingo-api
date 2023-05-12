package io.github.sd3v.mflashcardsbe.repository

import io.github.sd3v.mflashcardsbe.jooq.tables.Flashcard.FLASHCARD
import io.github.sd3v.mflashcardsbe.jooq.tables.pojos.Flashcard
import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository
import java.sql.Connection

@Repository
class FlashcardRepositoryImpl : FlashcardRepository {

    // TODO just to compile. remove later
    private val conn: Connection? = null
    private val ctx = DSL.using(conn, SQLDialect.POSTGRES)
    override fun findById(id: Long): FlashcardEntity? =
      ctx.select().from(FLASHCARD)
          .where(FLASHCARD.ID.equal(id))
          .fetchOne()
          ?.into(Flashcard::class.java)
          ?.let { FlashcardEntity(it.id, it.front, it.back, it.deckId) }

    override fun findAllByDeckId(deckId: Int): List<FlashcardEntity> =
        ctx.select().from(FLASHCARD)
            .where(FLASHCARD.DECK_ID.equal(deckId))
            .fetch()
            .into(Flashcard::class.java)
            .map { FlashcardEntity(it.id, it.front, it.back, it.deckId) }
}
