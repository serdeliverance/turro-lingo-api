package io.github.sd3v.mflashcardsbe.api.dto;

public class MenuItemDto {
  private String id;
  private String name;

  public MenuItemDto() {}

  public MenuItemDto(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
