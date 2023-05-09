package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.repository.entity.FlashcardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlashcardRepository extends CrudRepository<Long, FlashcardEntity> {

    Optional<Long> findById(Integer id);

    List<FlashcardEntity> findAllByDeckId(Integer id);
}
