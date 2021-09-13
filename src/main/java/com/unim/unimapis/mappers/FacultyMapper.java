package com.unim.unimapis.mappers;

import com.unim.unimapis.dtos.md.FacultyResponseDto;
import com.unim.unimapis.models.FacultyEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface FacultyMapper {
  @Mapping(target = "name", expression = "java(entity.getName(lang))")
  @Mapping(target = "mnemonic", expression= "java(lang)")
  FacultyResponseDto toDto(FacultyEntity entity, @Context String lang);

  List<FacultyResponseDto> toDtoList(List<FacultyEntity> entities, @Context String lang);
}
