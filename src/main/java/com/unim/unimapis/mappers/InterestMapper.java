package com.unim.unimapis.mappers;

import com.unim.unimapis.dtos.md.InterestResponseDto;
import com.unim.unimapis.models.InterestEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface InterestMapper {

  @Mapping(target = "name", expression = "java(entity.getName(lang))")
  @Mapping(target = "mnemonic", expression= "java(lang)")
  InterestResponseDto toDto(InterestEntity entity, @Context String lang);

  List<InterestResponseDto> toDtoList(List<InterestEntity> entities, @Context String lang);
}
