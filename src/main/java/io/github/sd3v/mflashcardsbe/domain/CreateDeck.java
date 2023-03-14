package io.github.sd3v.mflashcardsbe.domain;

import java.util.List;

public record CreateDeck(
    String name,
    String slug,
    String description,
    String type,
    String language,
    List<Flashcard> flashcards,
    List<String> tags) {}
