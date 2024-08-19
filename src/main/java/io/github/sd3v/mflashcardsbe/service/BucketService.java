package io.github.sd3v.mflashcardsbe.service;

import io.github.sd3v.mflashcardsbe.domain.Bucket;
import java.time.LocalDateTime;
import java.util.List;

import io.github.sd3v.mflashcardsbe.domain.BucketItem;
import io.github.sd3v.mflashcardsbe.repository.BucketRepository;
import org.springframework.stereotype.Service;

@Service
public class BucketService {

  private BucketRepository bucketRepository;
  private TranslationService translationService;
  private WordExampleOfUsageService wordExampleOfUsageService;

  // TODO research on which is the best time class to use here
  public Bucket create(int userId, List<String> words, LocalDateTime createdAt) {
    var bucketItems = words.stream().limit(5).map(this::createBucketItem).toList();

    if (bucketItems.isEmpty()) {
      return null;
    }

    bucketRepository.create(userId, bucketItems, createdAt);

    return null;
  }

  public BucketItem createBucketItem(String word) {
    // TODO implement
    return null;
  }
}
