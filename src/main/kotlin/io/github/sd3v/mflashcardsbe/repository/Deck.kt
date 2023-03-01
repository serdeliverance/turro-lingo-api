package io.github.sd3v.mflashcardsbe.repository

data class Deck(val name: String, val type: String, val tags: List<String>, val flashcards: List<Flashcard>)
