package com.unim.unimapis.services;

import com.unim.unimapis.dtos.authentication.AuthenticationRequestDto;
import com.unim.unimapis.dtos.authentication.AuthenticationResponseDto;
import com.unim.unimapis.dtos.authentication.RegistrationRequestDto;
import com.unim.unimapis.dtos.authentication.RegistrationResponseDto;

public interface AuthService {
  AuthenticationResponseDto login(AuthenticationRequestDto responseDto);

  RegistrationResponseDto register(RegistrationRequestDto requestDto);
}
