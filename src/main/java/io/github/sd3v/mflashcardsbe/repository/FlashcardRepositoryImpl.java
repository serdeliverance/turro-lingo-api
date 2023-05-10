package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class FlashcardRepositoryImpl implements FlashcardRepository {
  @Override
  public Optional<Long> findById(Integer id) {
    return Optional.empty();
  }

  @Override
  public List<FlashcardEntity> findAllByDeckId(Integer id) {
    return null;
  }
}
