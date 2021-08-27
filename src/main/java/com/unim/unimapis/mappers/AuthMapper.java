package com.unim.unimapis.mappers;

import com.unim.unimapis.dtos.authentication.AuthenticationResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {

  @Mapping(target = "token", source = "token")
  @Mapping(target = "username", source = "username")
  AuthenticationResponseDto toDto(String username, String token);
}
