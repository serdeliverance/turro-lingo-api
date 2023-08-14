package io.github.sd3v.mflashcardsbe.api.dto;

import io.github.sd3v.mflashcardsbe.domain.Article;
import java.util.List;

public record NounDto(
    Long id,
    String name,
    String description,
    Article article,
    String fullName,
    List<String> tags) {}
