package io.github.sd3v.mflashcardsbe.repository;

import lombok.Data;

import java.util.List;

@Data
public class Deck {
  private String name;
  private String type;
  private List<String> tags;
  private List<String> flashcards;
}
