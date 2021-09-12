package com.unim.unimapis.models.localization;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
@RequiredArgsConstructor
public class LocalizedId implements Serializable {
  Integer id;
  String lang;

  public LocalizedId(String lang) {
    this.lang = lang;
  }
}
