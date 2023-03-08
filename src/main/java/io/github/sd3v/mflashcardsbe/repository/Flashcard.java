package io.github.sd3v.mflashcardsbe.repository;

import lombok.Data;

@Data
public class Flashcard {
  private String front;
  private String back;
  private String example;
}
