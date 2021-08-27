package com.unim.unimapis.services;

import com.unim.unimapis.builders.dto.AuthenticationRequestDtoBuilder;
import com.unim.unimapis.builders.dto.AuthenticationResponseDtoBuilder;
import com.unim.unimapis.builders.entity.UserEntityBuilder;
import com.unim.unimapis.dtos.authentication.AuthenticationRequestDto;
import com.unim.unimapis.dtos.authentication.AuthenticationResponseDto;
import com.unim.unimapis.mappers.AuthMapper;
import com.unim.unimapis.mappers.RegistrationMapper;
import com.unim.unimapis.mappers.UserMapper;
import com.unim.unimapis.models.UserEntity;
import com.unim.unimapis.repository.RoleRepository;
import com.unim.unimapis.repository.UserRepository;
import com.unim.unimapis.security.jwt.JwtTokenProvider;
import com.unim.unimapis.services.impl.AuthServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AuthServiceImplTest {

  @Mock
  private AuthenticationManager authenticationManager;
  @Mock
  private JwtTokenProvider jwtTokenProvider;
  @Mock
  private UserService userService;
  @Mock
  private AuthMapper authMapper;
  @Mock
  private BCryptPasswordEncoder encoder;
  @Mock
  private RoleRepository roleRepository;
  @Mock
  private UserMapper userMapper;
  @Mock
  private UserRepository userRepository;
  @Mock
  private RegistrationMapper registrationMapper;
  @InjectMocks
  private AuthServiceImpl authService;

  @Test
  void test_login_ShouldReturn_Dto() {
    AuthenticationRequestDto requestDto = AuthenticationRequestDtoBuilder.withBasicData().build();
    AuthenticationResponseDto expected = AuthenticationResponseDtoBuilder.withBasicData().build();
    UserEntity userEntity = UserEntityBuilder.withBasicData().build();

    Mockito.when(userRepository.findByUsername(requestDto.getUsername())).thenReturn(Optional.of(userEntity));
    Mockito.when(jwtTokenProvider.createToken(requestDto.getUsername(), userEntity.getRoles())).thenReturn("test");
    Mockito.when(authMapper.toDto(requestDto.getUsername(), "test")).thenReturn(expected);
    AuthenticationResponseDto actual = authService.login(requestDto);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void test_register_ShouldReturnDto() {

  }


}
