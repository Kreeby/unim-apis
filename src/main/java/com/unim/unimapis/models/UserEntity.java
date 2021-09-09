package com.unim.unimapis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "users")
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

  @Column(name = "phone_number", length = 15, nullable = false)
  String phoneNumber;

  @Column(name = "email", length = 50, nullable = false, unique = true)
  String emailAddress;

  @Column(name = "password_hash", length = 32, nullable = false)
  String hashedPassword;

  @Column(name = "registered_at", nullable = false)
  LocalDateTime registeredAt;

  @Column(name = "last_login", nullable = false)
  LocalDateTime lastLogin;

  @Column(name = "intro")
  String introText;

  @Column(name = "profile")
  String profileText;

  @Column(name = "enabled")
  Boolean enabled;

  @OneToMany(mappedBy = "userEntity")
  Set<UserPostEntity> userPostEntities;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles",
          joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  Set<RoleEntity> roles;
}
