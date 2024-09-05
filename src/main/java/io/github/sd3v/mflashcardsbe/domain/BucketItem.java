package io.github.sd3v.mflashcardsbe.domain;

import java.util.List;

public record BucketItem(String word, String translation, List<String> example) {}
