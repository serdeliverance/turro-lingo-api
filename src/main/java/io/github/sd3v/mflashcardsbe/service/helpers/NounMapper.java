package io.github.sd3v.mflashcardsbe.service.helpers;

import static io.github.sd3v.mflashcardsbe.repository.common.TagParser.parseTags;

import io.github.sd3v.mflashcardsbe.domain.Noun;
import io.github.sd3v.mflashcardsbe.repository.entity.NounEntity;

public class NounMapper {

  public static Noun toDomain(NounEntity entity) {
    return new Noun(
        entity.id(),
        entity.name(),
        entity.description(),
        entity.article(),
        entity.fullName(),
        parseTags(entity.tags()));
  }
}
