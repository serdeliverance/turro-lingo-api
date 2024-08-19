package io.github.sd3v.mflashcardsbe.repository;

import io.github.sd3v.mflashcardsbe.domain.Bucket;
import io.github.sd3v.mflashcardsbe.domain.BucketItem;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BucketRepository {
    public Bucket create(int userId, List<BucketItem> bucketItems, LocalDateTime createdAt) {
        // TODO implement
        return null;
    }
}
