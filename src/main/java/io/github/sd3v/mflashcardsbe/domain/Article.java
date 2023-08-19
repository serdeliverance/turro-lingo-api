package io.github.sd3v.mflashcardsbe.domain;

public enum Article {
  DER("der"),
  DAS("das"),
  DIE("die");

  public final String article;

  Article(String article) {
    this.article = article;
  }
}
