package io.github.sd3v.mflashcardsbe.repository.entity;

public record DeckEntity(
    Long id,
    String name,
    String slug,
    String description,
    String type,
    String language,
    String tags) {}
