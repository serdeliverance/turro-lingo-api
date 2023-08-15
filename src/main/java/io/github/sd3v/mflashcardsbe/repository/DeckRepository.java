package io.github.sd3v.mflashcardsbe.repository;

import static io.github.sd3v.mflashcardsbe.jooq.Tables.DECK;
import static io.github.sd3v.mflashcardsbe.repository.common.TagParser.tagsAsString;

import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class DeckRepository {

  private final DSLContext create;

  public Optional<DeckEntity> findById(Long id) {
    return create.select().from(DECK).where(DECK.ID.eq(id)).fetchOptionalInto(DeckEntity.class);
  }

  public Optional<DeckEntity> findFirstBySlug(String slug) {
    return create.select().from(DECK).where(DECK.SLUG.eq(slug)).fetchOptionalInto(DeckEntity.class);
  }

  // TODO check the method parameter... maybe I should change it
  // TODO refactor this method (it could be cleaner)
  public DeckEntity save(CreateDeck createDeck) {
    log.info("Saving deck: {}", createDeck);

    var newDeck = create.newRecord(DECK);
    newDeck.setSlug(createDeck.slug());
    newDeck.setName(createDeck.name());
    newDeck.setDescription(createDeck.description());
    newDeck.setType(createDeck.type());
    newDeck.setLanguage(createDeck.language());
    newDeck.setTags(tagsAsString(createDeck.tags()));
    newDeck.setLanguage(createDeck.language());
    return create.insertInto(DECK).set(newDeck).returning().fetchOne().into(DeckEntity.class);
  }

  public List<DeckEntity> getAll() {
    return create.select().from(DECK).fetch().into(DeckEntity.class);
  }
}
