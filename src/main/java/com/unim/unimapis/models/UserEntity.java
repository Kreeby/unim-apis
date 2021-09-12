package com.unim.unimapis.models;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.unim.unimapis.models.converters.DegreeTypeJPAConverter;
import com.unim.unimapis.models.converters.GenderTypeJPAConverter;
import com.unim.unimapis.models.enums.DegreeType;
import com.unim.unimapis.models.enums.GenderType;
import lombok.AccessLevel;
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

  @Column(name = "phone_number", length = 15)
  String phoneNumber;

  @Column(name = "email", length = 50, nullable = false, unique = true)
  String emailAddress;

  @Column(name = "password_hash", length = 32, nullable = false)
  String hashedPassword;

  @Column(name = "gender",
          nullable = false,
          columnDefinition = "enum('Male', 'Female', 'Other')")
  @Convert(converter = GenderTypeJPAConverter.class)
  GenderType genderType;

  @Column(name = "degree",
          nullable = false,
          columnDefinition = "enum('Freshman', 'Master', 'Sophomore', 'Junior', 'Senior')")
  @Convert(converter = DegreeTypeJPAConverter.class)
  DegreeType degreeType;

  @Column(name = "enabled", nullable = false)
  Boolean enabled;

  @Column(name = "registered_at", nullable = false)
  LocalDateTime registeredAt;

  @Column(name = "last_login", nullable = false)
  LocalDateTime lastLogin;

  @Column(name = "intro")
  String introText;

  @Column(name = "profile")
  String profileText;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "uni_id")
  UniversityEntity universityEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id")
  LocationEntity locationEntity;

  @OneToMany(mappedBy = "userEntity")
  Set<UserPostEntity> userPostEntities;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles",
          joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  Set<RoleEntity> roles;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "map_users_interests",
          joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "interest_id", referencedColumnName = "id")})
  Set<InterestEntity> interestEntities;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "map_users_faculties",
          joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "faculty_id", referencedColumnName = "id")})
  Set<FacultyEntity> facultyEntities;
}
