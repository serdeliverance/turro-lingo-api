package io.github.sd3v.mflashcardsbe.repository;

import static io.github.sd3v.mflashcardsbe.jooq.Tables.FLASHCARD;

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

  private final DSLContext create;

  private static final Logger logger = LoggerFactory.getLogger(FlashcardRepository.class);

  public Optional<FlashcardEntity> findById(Long id) {
    //        create.select().from(FLASHCARD)
    //                .where(FLASHCARD.ID.equal(id))
    //                .fetchOne()
    //                ?.into(Flashcard::class.java)
    //            ?.let { FlashcardEntity(it.id, it.front, it.back, it.deckId) }
    return Optional.empty();
  }

  public List<FlashcardEntity> findAllByDeckId(Long deckId) {
    return create
        .select()
        .from(FLASHCARD)
        .where(FLASHCARD.DECK_ID.equal(deckId))
        .fetch()
        .into(FlashcardEntity.class);
  }

  // TODO implement
  // TODO check CreateFlashCard type
  public FlashcardEntity save(CreateFlashcard flashcard, Long deckId) {
    logger.info("Saving flashcard: {}", flashcard);

    var newFlashcard = create.newRecord(FLASHCARD);
    newFlashcard.setFront(flashcard.front());
    newFlashcard.setBack(flashcard.back());
    newFlashcard.setDeckId(deckId);
    return create
        .insertInto(FLASHCARD)
        .set(newFlashcard)
        .returning()
        .fetchOne()
        .into(FlashcardEntity.class);
  }

  public Optional<FlashcardEntity> findByDeckIdAndFront(Long deckId, String front) {
    return create
        .select()
        .from(FLASHCARD)
        .where(FLASHCARD.DECK_ID.eq(deckId).and(FLASHCARD.FRONT.eq(front)))
        .fetchOptionalInto(FlashcardEntity.class);
  }
}
