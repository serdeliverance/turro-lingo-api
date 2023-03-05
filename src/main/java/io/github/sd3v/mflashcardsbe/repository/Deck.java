package io.github.sd3v.mflashcardsbe.repository;

import java.util.List;
import lombok.Data;

@Data
public class Deck {
  private String name;
  private String type;
  private List<String> tags;
  private List<String> flashcards;
}
