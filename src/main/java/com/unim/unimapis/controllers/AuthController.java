package com.unim.unimapis.controllers;

import com.unim.unimapis.dtos.authentication.AuthenticationRequestDto;
import com.unim.unimapis.dtos.authentication.AuthenticationResponseDto;
import com.unim.unimapis.dtos.authentication.RegistrationRequestDto;
import com.unim.unimapis.dtos.authentication.RegistrationResponseDto;
import com.unim.unimapis.services.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequestMapping("/api/v1/auth")
public class AuthController {

  AuthService userService;

  @PostMapping("login")
  public ResponseEntity<AuthenticationResponseDto> login(
          @RequestBody AuthenticationRequestDto requestDto) {
    return ResponseEntity.ok(userService.login(requestDto));
  }

  @PostMapping("register")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<RegistrationResponseDto> register(
          @RequestBody RegistrationRequestDto requestDto) {
    return ResponseEntity.ok(userService.register(requestDto));
  }
}
