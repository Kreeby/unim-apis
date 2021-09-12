package com.unim.unimapis.services.impl;

import com.unim.unimapis.dtos.md.UniversityResponseDto;
import com.unim.unimapis.mappers.UniversityMapper;
import com.unim.unimapis.models.UniversityEntity;
import com.unim.unimapis.repository.UniversityRepository;
import com.unim.unimapis.services.MdService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MdServiceImpl implements MdService {

  UniversityRepository universityRepository;
  UniversityMapper universityMapper;

  @Override
  public List<UniversityResponseDto> findAllUniversities(String lang) {
    List<UniversityEntity> universityEntities = universityRepository.findAll();
    return universityMapper.toDtoList(universityEntities, lang);
  }
}
