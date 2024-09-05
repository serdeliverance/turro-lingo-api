package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.domain.Bucket;
import io.github.sd3v.mflashcardsbe.domain.BucketItem;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BucketRepository {

  private final DSLContext create;

  public Bucket create(
      int userId,
      Optional<String> description,
      List<BucketItem> bucketItems,
      ZonedDateTime createdAt) {
    // TODO implement
    return null;
  }
}
