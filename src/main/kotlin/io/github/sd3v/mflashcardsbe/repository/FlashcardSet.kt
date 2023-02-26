package io.github.sd3v.mflashcardsbe.repository

import org.springframework.data.annotation.Id

data class FlashcardSet(@Id val id: String, val subject: String, val language: String, val flashcards: List<Flashcard>, val tags: List<String>)
