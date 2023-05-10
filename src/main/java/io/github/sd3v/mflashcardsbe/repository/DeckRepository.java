package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository {
  Optional<DeckEntity> findFirstBySlug(String slug);

  List<DeckEntity> findAll();

  DeckEntity save(DeckEntity toEntity);
}
