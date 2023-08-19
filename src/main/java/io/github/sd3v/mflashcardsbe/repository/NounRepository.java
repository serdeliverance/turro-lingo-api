package io.github.sd3v.mflashcardsbe.repository;

import static io.github.sd3v.mflashcardsbe.jooq.tables.Noun.NOUN;
import static io.github.sd3v.mflashcardsbe.repository.common.TagParser.tagsAsString;

import io.github.sd3v.mflashcardsbe.domain.CreateNoun;
import io.github.sd3v.mflashcardsbe.repository.entity.NounEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class NounRepository {

  private final DSLContext create;

  public List<NounEntity> findAll() {
    return create.select().from(NOUN).fetchInto(NounEntity.class);
  }

  public Optional<NounEntity> findById(Long id) {
    return create.select().from(NOUN).where(NOUN.ID.eq(id)).fetchOptionalInto(NounEntity.class);
  }

  public NounEntity save(CreateNoun createNoun) {
    log.info("Saving noun: {}", createNoun);

    var newNoun = create.newRecord(NOUN);
    newNoun.setName(createNoun.name());
    newNoun.setDescription(createNoun.description());
    newNoun.setArticle(createNoun.article().toString());
    newNoun.setFullname(createNoun.fullName());
    newNoun.setTags(tagsAsString(createNoun.tags()));

    return create.insertInto(NOUN).set(newNoun).returning().fetchOne().into(NounEntity.class);
  }
}
