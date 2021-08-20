package com.unim.unimapis.services.impl;

import com.unim.unimapis.dtos.user.UserResponseDto;
import com.unim.unimapis.mappers.UserMapper;
import com.unim.unimapis.models.UserEntity;
import com.unim.unimapis.repository.UserRepository;
import com.unim.unimapis.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  UserRepository userRepository;
  UserMapper userMapper;

  @Override
  public List<UserResponseDto> findAllUsers() {
    List<UserEntity> foundUserEntities = userRepository.findAll();
    return userMapper.toDtoList(foundUserEntities);
  }
}
