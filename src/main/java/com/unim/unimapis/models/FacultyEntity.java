package com.unim.unimapis.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "faculties")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class FacultyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Integer id;

  @Column(name = "faculty_name", nullable = false)
  String name;

  @ManyToMany(mappedBy = "facultyEntities")
  Set<UserEntity> users;
}
