package io.github.sd3v.mflashcardsbe.api.dto;

public record FlashcardDto(
    Integer id, String front, String back, String createdAt, String updatedAt) {}
