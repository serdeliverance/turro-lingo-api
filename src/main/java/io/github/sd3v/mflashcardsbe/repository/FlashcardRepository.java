package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository {

  Optional<Long> findById(Integer id);

  List<FlashcardEntity> findAllByDeckId(Integer id);
}
