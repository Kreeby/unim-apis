package com.unim.unimapis.builders.dto;

import com.unim.unimapis.dtos.authentication.AuthenticationResponseDto;

public class AuthenticationResponseDtoBuilder {

  private final AuthenticationResponseDto authenticationResponseDto;

  public AuthenticationResponseDtoBuilder(AuthenticationResponseDto authenticationResponseDto) {
    this.authenticationResponseDto = authenticationResponseDto;
  }

  public static AuthenticationResponseDtoBuilder withBasicData() {
    AuthenticationResponseDto responseDto = new AuthenticationResponseDto();
    responseDto.setUsername("rashad");
    responseDto.setToken("test");
    return new AuthenticationResponseDtoBuilder(responseDto);
  }

  public AuthenticationResponseDto build() {
    return authenticationResponseDto;
  }
}
