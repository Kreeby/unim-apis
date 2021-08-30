package com.unim.unimapis.controllers;

import com.unim.unimapis.dtos.user.UserResponseDto;
import com.unim.unimapis.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {

  UserService userService;

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/users")
  public ResponseEntity<List<UserResponseDto>> findAllUsers() {
    return ResponseEntity.ok(userService.findAllUsers());
  }
}
