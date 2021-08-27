package com.unim.unimapis.dtos.user;

import com.unim.unimapis.models.UserPostEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {

  Integer id;
  String firstName;
  String middleName;
  String lastName;
  String username;
  String phoneNumber;
  String emailAddress;
  String hashedPassword;
  Boolean enabled;
  LocalDateTime registeredAt;
  LocalDateTime lastLogin;
  String introText;
  String profileText;
  Set<UserPostEntity> userPosts;

}
