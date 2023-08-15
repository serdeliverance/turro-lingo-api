package io.github.sd3v.mflashcardsbe.repository.entity;

import io.github.sd3v.mflashcardsbe.domain.Article;

public record NounEntity(
    Long id, String name, String description, Article article, String fullName, String tags) {}
