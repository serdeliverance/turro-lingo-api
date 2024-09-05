package io.github.sd3v.mflashcardsbe.service;

import io.github.sd3v.mflashcardsbe.domain.Bucket;
import io.github.sd3v.mflashcardsbe.domain.BucketItem;
import io.github.sd3v.mflashcardsbe.repository.BucketRepository;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BucketService {

  private BucketRepository bucketRepository;
  private TranslationService translationService;
  private WordExampleFinderService wordExampleFinderService;

  // TODO research on which is the best time class to use here
  public Bucket create(
      int userId, Optional<String> description, List<String> words, ZonedDateTime createdAt) {
    var bucketItems = words.stream().limit(5).map(this::createBucketItem).toList();

    if (bucketItems.isEmpty()) {
      return null;
    }

    bucketRepository.create(userId, description, bucketItems, createdAt);

    return null;
  }

  public BucketItem createBucketItem(String word) {
    // TODO implement
    return null;
  }
}
