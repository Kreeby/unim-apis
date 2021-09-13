package com.unim.unimapis.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum GenderType {
  MALE("Male"),
  FEMALE("Female"),
  OTHER("Other");

  final String value;

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static GenderType fromValue(String value) {
    return Stream.of(values())
            .filter(option -> option.getValue().equalsIgnoreCase(value))
            .findFirst()
            .orElse(GenderType.OTHER);
  }
}
