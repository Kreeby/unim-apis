package com.unim.unimapis.builders.dto;

import com.unim.unimapis.dtos.authentication.AuthenticationRequestDto;

public class AuthenticationRequestDtoBuilder {

  private final AuthenticationRequestDto authenticationRequestDto;

  public AuthenticationRequestDtoBuilder(AuthenticationRequestDto authenticationRequestDto) {
    this.authenticationRequestDto = authenticationRequestDto;
  }

  public static AuthenticationRequestDtoBuilder withBasicData() {
    AuthenticationRequestDto requestDto = new AuthenticationRequestDto();
    requestDto.setUsername("rashad");
    requestDto.setPassword("test");
    return new AuthenticationRequestDtoBuilder(requestDto);
  }

  public AuthenticationRequestDto build() {
    return authenticationRequestDto;
  }
}
