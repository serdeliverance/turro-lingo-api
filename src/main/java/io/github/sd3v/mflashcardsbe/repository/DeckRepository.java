package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static io.github.sd3v.mflashcardsbe.jooq.Tables.DECK;

@Repository
@RequiredArgsConstructor
public class DeckRepository {

    private final DSLContext create;

    private static final Logger logger = LoggerFactory.getLogger(DeckRepository.class);

    public Optional<DeckEntity> findById(Long id) {
        // TODO implement
//        create.select().from(DECK)
//                .where(DECK.ID.eq(id))
//                .fetchOne()?.into(DECK)?.let { r -> DeckEntity(r.id, r.name, r.slug, r.description, r.type, r.language, r.tags) }
        return Optional.empty();
    }

    public Optional<DeckEntity> findFirstBySlug(String slug) {
//        return create.select().from(DECK)
//                .where(DECK.SLUG.eq(slug))
//                .fetchOne()?.into(DECK)?.let { r -> DeckEntity(r.id, r.name, r.slug, r.description, r.type, r.language, r.tags) }
        return Optional.empty();
    }

    // TODO check the method parameter... maybe I should change it
    // TODO refactor this method (it could be cleaner)
    public DeckEntity save(CreateDeck createDeck) {
//        logger.info("Saving deck: {}", deck)
//
//        val newDeck = create.newRecord(DECK)
//        newDeck.slug = deck.slug
//        newDeck.name = deck.name
//        newDeck.description = deck.description
//        newDeck.type = deck.type
//        newDeck.language = deck.language
//        newDeck.tags = deck.tags.joinToString(",")
//        newDeck.language = deck.language
//        // TODO return just id (to optimize data transfer) and create DeckEntity with the values we already have
//        return create.insertInto(DECK).set(newDeck).returning().fetchOne {
//            r ->
//                    DeckEntity(r.id, r.name, r.slug, r.description, r.type, r.language, r.tags)
//        }!!
        
        return null;
    }
}
