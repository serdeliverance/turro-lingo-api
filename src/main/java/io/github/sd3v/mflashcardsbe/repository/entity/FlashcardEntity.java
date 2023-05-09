package io.github.sd3v.mflashcardsbe.repository.entity;

import org.springframework.data.annotation.Id;

public record FlashcardEntity(@Id Integer id, String front, String back, Integer deckId) {}
