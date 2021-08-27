package com.unim.unimapis.dtos.authentication;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationResponseDto {
  Integer id;
  String firstName;
  String middleName;
  String lastName;
  String userName;
  String phoneNumber;
  String email;
  String password;
  String intro;
  String profile;
  LocalDateTime lastLogin;
  LocalDateTime registeredAt;
}
