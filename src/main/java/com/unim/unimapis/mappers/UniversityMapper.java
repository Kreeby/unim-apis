package com.unim.unimapis.mappers;

import com.unim.unimapis.dtos.md.UniversityResponseDto;
import com.unim.unimapis.models.UniversityEntity;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UniversityMapper {

  @Mapping(target = "name", expression = "java(entity.getName(lang))")
  @Mapping(target = "mnemonic", expression= "java(lang)")
  UniversityResponseDto toDto(UniversityEntity entity, @Context String lang);

  List<UniversityResponseDto> toDtoList(List<UniversityEntity> entities, @Context String lang);
}
