package com.unim.unimapis.dtos.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

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
  LocalDateTime registeredAt;
  LocalDateTime lastLogin;
  String introText;
  String profileText;

}
