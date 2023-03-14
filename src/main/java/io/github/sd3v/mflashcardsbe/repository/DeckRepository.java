package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends ReactiveMongoRepository<DeckEntity, String> {}
