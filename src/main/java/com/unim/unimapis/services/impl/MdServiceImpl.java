package com.unim.unimapis.services.impl;

import com.unim.unimapis.dtos.md.FacultyResponseDto;
import com.unim.unimapis.dtos.md.InterestResponseDto;
import com.unim.unimapis.dtos.md.UniversityResponseDto;
import com.unim.unimapis.mappers.FacultyMapper;
import com.unim.unimapis.mappers.InterestMapper;
import com.unim.unimapis.mappers.UniversityMapper;
import com.unim.unimapis.models.FacultyEntity;
import com.unim.unimapis.models.InterestEntity;
import com.unim.unimapis.models.UniversityEntity;
import com.unim.unimapis.repository.FacultyRepository;
import com.unim.unimapis.repository.InterestRepository;
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
  FacultyRepository facultyRepository;
  InterestRepository interestRepository;
  UniversityMapper universityMapper;
  FacultyMapper facultyMapper;
  InterestMapper interestMapper;

  @Override
  public List<UniversityResponseDto> findAllUniversities(String lang) {
    List<UniversityEntity> universityEntities = universityRepository.findAll();
    return universityMapper.toDtoList(universityEntities, lang);
  }

  @Override
  public List<FacultyResponseDto> findAllFaculties(String lang) {
    List<FacultyEntity> facultyEntities = facultyRepository.findAll();
    return facultyMapper.toDtoList(facultyEntities, lang);
  }

  @Override
  public List<InterestResponseDto> findAllInterests(String lang) {
    List<InterestEntity> interestEntities = interestRepository.findAll();
    return interestMapper.toDtoList(interestEntities, lang);
  }
}
