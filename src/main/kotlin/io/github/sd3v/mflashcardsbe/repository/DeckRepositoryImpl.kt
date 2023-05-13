package io.github.sd3v.mflashcardsbe.repository

import io.github.sd3v.mflashcardsbe.domain.CreateDeck
import io.github.sd3v.mflashcardsbe.jooq.Tables.DECK
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class DeckRepositoryImpl(val create: DSLContext) : DeckRepository {

    override fun findFirstBySlug(slug: String): DeckEntity? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<DeckEntity> {
        TODO("Not yet implemented")
    }

    // TODO refactor this method (it could be cleaner)
    override fun save(deck: CreateDeck): DeckEntity {
        val newDeck = create.newRecord(DECK)
        newDeck.slug = deck.slug
        newDeck.name = deck.name
        newDeck.description = deck.description
        newDeck.language = deck.language
        newDeck.tags = deck.tags.joinToString(",")
        newDeck.language = deck.language
        // TODO return just id (to optimize data transfer) and create DeckEntity with the values we already have
        return create.insertInto(DECK).set(newDeck).returning().fetchOne {
                r ->
            DeckEntity(r.id, r.name, r.slug, r.description, r.type, r.language, r.tags)
        }!!
    }
}
