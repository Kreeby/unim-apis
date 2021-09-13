package com.unim.unimapis.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "interests")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class InterestEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Integer id;

  @ManyToMany(mappedBy = "interestEntities")
  Set<UserEntity> users;

  @OneToMany(mappedBy = "interestEntity",
          cascade = {
                  CascadeType.DETACH,
                  CascadeType.MERGE,
                  CascadeType.PERSIST,
                  CascadeType.REFRESH},
          orphanRemoval = true)
  @MapKey(name = "localizedId.lang")
  @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
  Map<String, LocalizedInterest> localizations = new HashMap<>();

  public String getName(String lang) {
    return localizations.get(lang).getNameTranslated();
  }
}
