package io.github.sd3v.mflashcardsbe.service

import io.github.sd3v.mflashcardsbe.repository.FlaschcardSetRepository
import io.github.sd3v.mflashcardsbe.repository.FlashcardSet
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class FlashcardSetService(val flashcardSetRepository: FlaschcardSetRepository) {
    fun getAll(): Flux<FlashcardSet> = Flux.empty()
}
