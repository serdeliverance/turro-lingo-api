package io.github.sd3v.mflashcardsbe.repository.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record DeckEntity(
    @Id String id,
    String name,
    String slug,
    String description,
    String type,
    String language,
    List<FlashcardEntity> flashcards,
    List<String> tags) {}
