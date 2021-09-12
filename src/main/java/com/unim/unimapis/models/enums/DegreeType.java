package com.unim.unimapis.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum DegreeType {
  FRESHMAN("Freshman", null),
  MASTER("Master", null),
  SOPHOMORE("Sophomore", null),
  JUNIOR("Junior", null),
  SENIOR("Senior", null);

  final String value;
  final Boolean status;

  @JsonCreator
  public static DegreeType fromValue(String value) {
    return Stream.of(values())
            .filter(option -> option.getValue().equalsIgnoreCase(value))
            .findFirst()
            .orElse(DegreeType.SENIOR);
  }
}
