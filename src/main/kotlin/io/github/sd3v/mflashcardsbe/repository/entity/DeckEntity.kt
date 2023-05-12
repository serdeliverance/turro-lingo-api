package io.github.sd3v.mflashcardsbe.repository.entity

data class DeckEntity(
    val id: Long,
    val name: String,
    val slug: String,
    val description: String,
    val type: String,
    val language: String,
    val tags: String,
)
