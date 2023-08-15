package io.github.sd3v.mflashcardsbe.api.dto;

import java.util.List;

public record CreateNounDto(
    String name, String description, String article, String fullName, List<String> tags) {}
