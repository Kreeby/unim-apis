package com.unim.unimapis.dtos.authentication;

import com.unim.unimapis.models.RoleEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationRequestDto {
  String firstName;
  String middleName;
  String lastName;
  String phoneNumber;
  String emailAddress;
  String password;
  String introText;
  String profileText;
  String username;
  List<Integer> roles;
}
