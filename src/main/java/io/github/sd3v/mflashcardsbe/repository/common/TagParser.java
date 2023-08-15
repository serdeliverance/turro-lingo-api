package io.github.sd3v.mflashcardsbe.repository.common;

import java.util.Arrays;
import java.util.List;

public class TagParser {

  public static List<String> parseTags(String tagsStr) {
    return Arrays.stream(tagsStr.split(",")).toList();
  }

  public static String tagsAsString(List<String> tags) {
    return String.join(",", tags);
  }
}
