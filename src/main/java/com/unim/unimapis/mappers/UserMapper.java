package com.unim.unimapis.mappers;

import com.unim.unimapis.dtos.user.UserResponseDto;
import com.unim.unimapis.models.UserEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  UserResponseDto toDto(UserEntity userEntity);

  List<UserResponseDto> toDtoList(List<UserEntity> userEntities);
}
