package com.unim.unimapis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Integer id;

  @Column(name = "first_name", length = 50, nullable = false)
  String firstName;

  @Column(name = "middle_name", length = 50, nullable = false)
  String middleName;

  @Column(name = "last_name", length = 50, nullable = false)
  String lastName;

  @Column(name = "username", length = 50, nullable = false, unique = true)
  String username;

  @Column(name = "phone_number", length = 15, nullable = false)
  String phoneNumber;

  @Column(name = "email", length = 50)
  String emailAddress;

  @Column(name = "password_hash", length = 32, nullable = false)
  String hashedPassword;

  @Column(name = "registered_at")
  LocalDateTime registeredAt;

  @Column(name = "last_login")
  LocalDateTime lastLogin;

  @Column(name = "intro")
  String introText;

  @Column(name = "profile")
  String profileText;

  @OneToMany(mappedBy = "user")
  Set<UserPostEntity> userPostEntities;
}
