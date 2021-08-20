package com.unim.unimapis.services;

import com.unim.unimapis.dtos.user.UserResponseDto;

import java.util.List;

public interface UserService {

  List<UserResponseDto> findAllUsers();
}
