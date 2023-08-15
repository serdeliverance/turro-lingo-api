package io.github.sd3v.mflashcardsbe.api.helpers;

import io.github.sd3v.mflashcardsbe.api.dto.CreateNounDto;
import io.github.sd3v.mflashcardsbe.api.dto.NounDto;
import io.github.sd3v.mflashcardsbe.domain.Article;
import io.github.sd3v.mflashcardsbe.domain.CreateNoun;
import io.github.sd3v.mflashcardsbe.domain.Noun;

public class NounsMapper {

  public static NounDto toDto(Noun noun) {
    return new NounDto(
        noun.id(),
        noun.name(),
        noun.description(),
        noun.article().toString(),
        noun.fullName(),
        noun.tags());
  }

  public static CreateNoun toDomain(CreateNounDto dto) {
    return new CreateNoun(
        dto.name(),
        dto.description(),
        Article.valueOf(dto.article().toUpperCase()),
        dto.fullName(),
        dto.tags());
  }
}
