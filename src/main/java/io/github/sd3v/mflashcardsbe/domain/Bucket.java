package io.github.sd3v.mflashcardsbe.domain;

import java.util.List;
import java.util.Optional;

public record Bucket(Optional<String> description, List<String> words) {}
