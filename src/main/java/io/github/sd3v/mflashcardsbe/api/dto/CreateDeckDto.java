package io.github.sd3v.mflashcardsbe.api.dto;

import java.util.List;

public record CreateDeckDto(
    String name,
    String slug,
    String description,
    String type,
    String language,
    List<FlashcardDto> flashcards,
    List<String> tags) {}
