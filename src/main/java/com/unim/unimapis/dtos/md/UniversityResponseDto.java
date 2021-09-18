package com.unim.unimapis.dtos.md;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unim.unimapis.models.UniversityEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniversityResponseDto {
  @JsonProperty("data")
  Page<UniversityEntity> universityEntities;
}
