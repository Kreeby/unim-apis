package com.unim.unimapis.mappers;

import com.unim.unimapis.dtos.authentication.RegistrationResponseDto;
import com.unim.unimapis.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RegistrationMapper {

  @Mapping(target = "userName", source = "username")
  @Mapping(target = "profile", source = "profileText")
  @Mapping(target = "password", source = "hashedPassword")
  @Mapping(target = "intro", source = "introText")
  @Mapping(target = "email", source = "emailAddress")
  RegistrationResponseDto toDto(UserEntity userEntity);
}
