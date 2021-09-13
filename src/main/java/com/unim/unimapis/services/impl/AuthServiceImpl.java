package com.unim.unimapis.services.impl;

import com.unim.unimapis.dtos.authentication.AuthenticationRequestDto;
import com.unim.unimapis.dtos.authentication.AuthenticationResponseDto;
import com.unim.unimapis.dtos.authentication.RegistrationRequestDto;
import com.unim.unimapis.dtos.authentication.RegistrationResponseDto;
import com.unim.unimapis.mappers.AuthMapper;
import com.unim.unimapis.mappers.RegistrationMapper;
import com.unim.unimapis.mappers.UserMapper;
import com.unim.unimapis.models.FacultyEntity;
import com.unim.unimapis.models.InterestEntity;
import com.unim.unimapis.models.LocationEntity;
import com.unim.unimapis.models.RoleEntity;
import com.unim.unimapis.models.UserEntity;
import com.unim.unimapis.repository.FacultyRepository;
import com.unim.unimapis.repository.InterestRepository;
import com.unim.unimapis.repository.LocationRepository;
import com.unim.unimapis.repository.RoleRepository;
import com.unim.unimapis.repository.UserRepository;
import com.unim.unimapis.security.jwt.JwtTokenProvider;
import com.unim.unimapis.services.AuthService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  AuthenticationManager authenticationManager;
  JwtTokenProvider jwtTokenProvider;
  AuthMapper authMapper;
  BCryptPasswordEncoder passwordEncoder;
  RoleRepository roleRepository;
  UserMapper userMapper;
  UserRepository userRepository;
  InterestRepository interestRepository;
  FacultyRepository facultyRepository;
  LocationRepository locationRepository;
  RegistrationMapper registrationMapper;

  @Override
  public AuthenticationResponseDto login(AuthenticationRequestDto requestDto) {
    String email = requestDto.getEmail();
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, requestDto.getPassword()));

    UserEntity user = userRepository.findByEmailAddress(email)
            .orElseThrow(() -> new NoSuchElementException("No such user with username " + email));
    String token = jwtTokenProvider.createToken(email, user.getRoles());

    System.out.println(token + " " + user);

    return authMapper.toDto(email, token);
  }

  @Override
  public RegistrationResponseDto register(RegistrationRequestDto requestDto) {
    List<InterestEntity> interestEntities = interestRepository.findAllById(requestDto.getInterestIds());
    List<RoleEntity> roleEntities = roleRepository.findAllByRoleName("USER")
            .orElseThrow(() -> new NoSuchElementException("Server error 500"));
    List<FacultyEntity> facultyEntities = facultyRepository.findAllById(requestDto.getFacultyId());
    UserEntity userEntity = userMapper.toEntity(
            requestDto,
            roleEntities,
            interestEntities,
            facultyEntities);
    userEntity.setHashedPassword(passwordEncoder.encode(requestDto.getPassword()));
    UserEntity savedUser = userRepository.save(userEntity);

    return registrationMapper.toDto(savedUser);
  }
}
