package com.unim.unimapis.services;

import com.unim.unimapis.dtos.user.UserResponseDto;
import com.unim.unimapis.models.UserEntity;

import java.util.List;

public interface UserService {

  UserEntity findByUsername(String username);

  List<UserResponseDto> findAllUsers();
}
