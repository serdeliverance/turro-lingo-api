package io.github.sd3v.mflashcardsbe.api.dto;

import java.time.LocalDateTime;
import java.util.List;

public record BucketDto(Integer id, List<BucketItemDto> items, LocalDateTime createdAt) {}
