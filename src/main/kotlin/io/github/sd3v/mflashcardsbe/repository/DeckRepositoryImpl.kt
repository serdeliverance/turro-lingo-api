package io.github.sd3v.mflashcardsbe.repository

import io.github.sd3v.mflashcardsbe.domain.CreateDeck
import io.github.sd3v.mflashcardsbe.jooq.Tables.DECK
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity
import org.jooq.DSLContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class DeckRepositoryImpl(val create: DSLContext) : DeckRepository {

    private val logger = LoggerFactory.getLogger(DeckRepositoryImpl::class.java)

    override fun findFirstBySlug(slug: String): DeckEntity? =
        create.select().from(DECK)
            .where(DECK.SLUG.eq(slug))
            .fetchOne()?.into(DECK)?.let { r -> DeckEntity(r.id, r.name, r.slug, r.description, r.type, r.language, r.tags) }

    override fun findAll(): List<DeckEntity> {
        TODO("Not yet implemented")
    }

    // TODO refactor this method (it could be cleaner)
    override fun save(deck: CreateDeck): DeckEntity {
        logger.info("Saving deck: {}", deck)

        val newDeck = create.newRecord(DECK)
        newDeck.slug = deck.slug
        newDeck.name = deck.name
        newDeck.description = deck.description
        newDeck.type = deck.type
        newDeck.language = deck.language
        newDeck.tags = deck.tags.joinToString(",")
        newDeck.language = deck.language
        // TODO return just id (to optimize data transfer) and create DeckEntity with the values we already have
        return create.insertInto(DECK).set(newDeck).returning().fetchOne {
                r ->
            DeckEntity(r.id, r.name, r.slug, r.description, r.type, r.language, r.tags)
        }!!
    }

    override fun findById(id: Long): DeckEntity? =
        create.select().from(DECK)
            .where(DECK.ID.eq(id))
            .fetchOne()?.into(DECK)?.let { r -> DeckEntity(r.id, r.name, r.slug, r.description, r.type, r.language, r.tags) }
}
