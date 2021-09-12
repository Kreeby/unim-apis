package com.unim.unimapis.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum GenderType {
  MALE("Male", null),
  FEMALE("Female", null),
  OTHER("Other", null);

  final String value;
  final Boolean status;

  @JsonCreator
  public static GenderType fromValue(String value) {
    return Stream.of(values())
            .filter(option -> option.getValue().equalsIgnoreCase(value))
            .findFirst()
            .orElse(GenderType.OTHER);
  }
}
