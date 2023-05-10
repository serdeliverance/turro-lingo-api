package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.repository.entity.DeckEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class DeckRepositoryImpl implements DeckRepository {
  @Override
  public Optional<DeckEntity> findFirstBySlug(String slug) {
    return Optional.empty();
  }

  @Override
  public List<DeckEntity> findAll() {
    return null;
  }

  @Override
  public DeckEntity save(DeckEntity toEntity) {
    return null;
  }
}
