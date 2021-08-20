package com.unim.unimapis.mappers;

import com.unim.unimapis.dtos.user.UserResponseDto;
import com.unim.unimapis.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  UserResponseDto toDto(UserEntity userEntity);

  List<UserResponseDto> toDtoList(List<UserEntity> userEntities);
}
