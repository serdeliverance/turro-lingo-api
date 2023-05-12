package io.github.sd3v.mflashcardsbe.repository

import io.github.sd3v.mflashcardsbe.io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity
import org.springframework.stereotype.Repository

@Repository
class DeckRepositoryImpl : DeckRepository {
    override fun findFirstBySlug(slug: String): DeckEntity? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<DeckEntity> {
        TODO("Not yet implemented")
    }

    override fun save(deck: DeckEntity): DeckEntity {
        TODO("Not yet implemented")
    }
}
