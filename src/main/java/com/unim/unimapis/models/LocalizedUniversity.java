package com.unim.unimapis.models;

import com.unim.unimapis.models.localization.LocalizedId;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Getter
@Setter
@Entity
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "localized_universities")
public class LocalizedUniversity {
  @EmbeddedId
  LocalizedId localizedId;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "id")
  UniversityEntity universityEntity;

  String nameTranslated;
}
