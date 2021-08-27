package com.unim.unimapis.mappers;

import com.unim.unimapis.dtos.authentication.RegistrationRequestDto;
import com.unim.unimapis.dtos.authentication.RegistrationResponseDto;
import com.unim.unimapis.dtos.user.UserResponseDto;
import com.unim.unimapis.models.RoleEntity;
import com.unim.unimapis.models.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        imports = {BCryptPasswordEncoder.class, LocalDateTime.class})
public interface UserMapper {


  UserResponseDto toDto(UserEntity userEntity);

  List<UserResponseDto> toDtoList(List<UserEntity> userEntities);


  @Mapping(target = "lastLogin", expression = "java(LocalDateTime.now())")
  @Mapping(target = "registeredAt", expression = "java(LocalDateTime.now())")
  @Mapping(target = "roles", source = "roleEntities")
  @Mapping(target = "enabled", expression = "java(true)")
  UserEntity toEntity(RegistrationRequestDto requestDto, List<RoleEntity> roleEntities);
}
