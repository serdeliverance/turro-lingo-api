package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.domain.CreateFlashcard;
import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FlashcardRepository {

  private final DSLContext context;

  private static final Logger logger = LoggerFactory.getLogger(FlashcardRepository.class);

  public Optional<FlashcardEntity> findById(Long id) {
    //        create.select().from(FLASHCARD)
    //                .where(FLASHCARD.ID.equal(id))
    //                .fetchOne()
    //                ?.into(Flashcard::class.java)
    //            ?.let { FlashcardEntity(it.id, it.front, it.back, it.deckId) }
    return Optional.empty();
  }

  // TODO implement
  public List<FlashcardEntity> findAllByDeckId(Long id) {
    //        create.select().from(FLASHCARD)
    //                .where(FLASHCARD.DECK_ID.equal(deckId))
    //                .fetch()
    //                .into(Flashcard::class.java)
    //            .map { FlashcardEntity(it.id, it.front, it.back, it.deckId) }
    return null;
  }

  // TODO implement
  // TODO check CreateFlashCard type
  public FlashcardEntity save(CreateFlashcard flashcard, Long id) {
    //        logger.info("Saving flashcard: {}", flashcard)
    //
    //        val newFlashcard = create.newRecord(Tables.FLASHCARD)
    //        newFlashcard.front = flashcard.front
    //        newFlashcard.back = flashcard.back
    //        newFlashcard.deckId = deckId
    //        // TODO return just id (to optimize data transfer) and create DeckEntity with the
    // values we already have
    //        return create.insertInto(Tables.FLASHCARD).set(newFlashcard).returning().fetchOne {
    //            r ->
    //                    FlashcardEntity(r.id, r.front, r.back, r.deckId)
    //        }!!
    return null;
  }
}
