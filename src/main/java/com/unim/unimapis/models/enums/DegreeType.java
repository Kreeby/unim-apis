package com.unim.unimapis.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum DegreeType {
  FRESHMAN("Freshman"),
  MASTER("Master"),
  SOPHOMORE("Sophomore"),
  JUNIOR("Junior"),
  SENIOR("Senior");

  final String value;

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static DegreeType fromValue(String value) {
    return Stream.of(values())
            .filter(option -> option.getValue().equalsIgnoreCase(value))
            .findFirst()
            .orElse(DegreeType.SENIOR);
  }
}
