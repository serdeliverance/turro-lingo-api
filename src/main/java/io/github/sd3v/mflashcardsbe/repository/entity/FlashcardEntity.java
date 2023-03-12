package io.github.sd3v.mflashcardsbe.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record FlashcardEntity(
    @Id Integer id, String front, String back) {}
