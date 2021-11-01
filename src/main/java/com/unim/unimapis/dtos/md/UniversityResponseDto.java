package com.unim.unimapis.dtos.md;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniversityResponseDto {
  Integer id;
  String name;
  String mnemonic;
}
