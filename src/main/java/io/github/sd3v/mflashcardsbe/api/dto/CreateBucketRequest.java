package io.github.sd3v.mflashcardsbe.api.dto;

import java.util.List;
import java.util.Optional;

public record CreateBucketRequest(Optional<String> description, List<String> words) {}
