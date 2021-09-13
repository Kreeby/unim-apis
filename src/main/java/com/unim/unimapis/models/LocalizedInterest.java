package com.unim.unimapis.models;

import com.unim.unimapis.models.localization.LocalizedId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "localized_interests")
public class LocalizedInterest {
  @EmbeddedId
  LocalizedId localizedId;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "id")
  InterestEntity interestEntity;

  String nameTranslated;
}
