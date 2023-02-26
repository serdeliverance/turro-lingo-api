package io.github.sd3v.mflashcardsbe.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FlaschcardSetRepository : ReactiveCrudRepository<FlashcardSet, String>{
}