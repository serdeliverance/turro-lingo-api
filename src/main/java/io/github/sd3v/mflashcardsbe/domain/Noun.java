package io.github.sd3v.mflashcardsbe.domain;

import java.util.List;

public record Noun(
    Long id,
    String name,
    String description,
    Article article,
    String fullName,
    List<String> tags) {}
