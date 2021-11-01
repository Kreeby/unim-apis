package com.unim.unimapis.services;

import com.unim.unimapis.dtos.authentication.AuthenticationRequestDto;
import com.unim.unimapis.dtos.authentication.AuthenticationResponseDto;
import com.unim.unimapis.dtos.authentication.RegistrationRequestDto;
import com.unim.unimapis.dtos.authentication.RegistrationResponseDto;
import com.unim.unimapis.models.UserEntity;

public interface AuthService {
  AuthenticationResponseDto login(AuthenticationRequestDto responseDto);

  RegistrationResponseDto register(RegistrationRequestDto requestDto);

//  UserEntity getCurrentUser();
}
