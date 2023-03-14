package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DeckRepository extends ReactiveMongoRepository<DeckEntity, String> {
  Mono<DeckEntity> findFirstBySlug(String slug);
}
