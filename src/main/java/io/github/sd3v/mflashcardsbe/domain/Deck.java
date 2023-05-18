package io.github.sd3v.mflashcardsbe.domain;

import java.util.List;

public record Deck(
    Long id,
    String name,
    String slug,
    String description,
    String type,
    String language,
    List<Flashcard> flashcards,
    List<String> tags) {}
