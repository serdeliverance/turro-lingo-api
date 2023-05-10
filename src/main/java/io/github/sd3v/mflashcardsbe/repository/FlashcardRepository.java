package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity;
import java.util.List;
import java.util.Optional;

public interface FlashcardRepository {

  Optional<Long> findById(Integer id);

  List<FlashcardEntity> findAllByDeckId(Integer id);
}
