package com.unim.unimapis.mappers;

import com.unim.unimapis.dtos.md.UniversityResponseDto;
import com.unim.unimapis.models.UniversityEntity;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UniversityMapper {

}
