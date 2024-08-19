package io.github.sd3v.mflashcardsbe.api;

import io.github.sd3v.mflashcardsbe.api.dto.BucketDto;
import io.github.sd3v.mflashcardsbe.api.dto.CreateBucketRequest;
import io.github.sd3v.mflashcardsbe.api.helpers.BucketMapper;
import io.github.sd3v.mflashcardsbe.service.BucketService;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buckets")
@RequiredArgsConstructor
public class BucketController {

  private final BucketService bucketService;

  @PostMapping
  public BucketDto create(CreateBucketRequest request) {
    var bucket = bucketService.create(1, request.words(), LocalDateTime.now());
    return BucketMapper.toDto(bucket);
  }
}
