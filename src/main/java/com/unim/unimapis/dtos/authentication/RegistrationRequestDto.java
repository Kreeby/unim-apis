package com.unim.unimapis.dtos.authentication;

import com.unim.unimapis.models.enums.DegreeType;
import com.unim.unimapis.models.enums.GenderType;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationRequestDto {
  @NonNull
  String firstName;
  @NonNull
  String middleName;
  @NonNull
  String lastName;
  String phoneNumber;
  @NonNull
  String emailAddress;
  @NonNull
  String password;
  @NonNull
  GenderType genderType;
  @NonNull
  DegreeType degreeType;
  String introText;
  String profileText;
  @NonNull
  Integer universityId;
  @NonNull
  Integer locationId;
  @NonNull
  String lang;
  @NonNull
  List<Integer> interestIds;
  @NonNull
  List<Integer> facultyId;

}
