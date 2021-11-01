package com.unim.unimapis.services.impl;

import com.unim.unimapis.dtos.md.UniversityResponseDto;
import com.unim.unimapis.mappers.UniversityMapper;
import com.unim.unimapis.models.LocalizedFaculty;
import com.unim.unimapis.models.LocalizedInterest;
import com.unim.unimapis.models.LocalizedUniversity;
import com.unim.unimapis.models.UniversityEntity;
import com.unim.unimapis.models.UserEntity;
import com.unim.unimapis.repository.LocalizedFacultyRepository;
import com.unim.unimapis.repository.LocalizedInterestRepository;
import com.unim.unimapis.repository.LocalizedUniversityRepository;
import com.unim.unimapis.repository.UniversityRepository;
import com.unim.unimapis.services.AuthService;
import com.unim.unimapis.services.MdService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MdServiceImpl implements MdService {

  LocalizedUniversityRepository localizedUniversityRepository;
  LocalizedFacultyRepository localizedFacultyRepository;
  LocalizedInterestRepository localizedInterestRepository;
  UniversityRepository universityRepository;
  UniversityMapper universityMapper;
  AuthService authService;

  @Override
  public Page<LocalizedUniversity> findAllUniversities(String lang, Pageable pageable) {
    return localizedUniversityRepository.findAllByLocalizedId_Lang(lang, pageable);
  }

  @Override
  public Page<LocalizedFaculty> findAllFaculties(String lang, Pageable pageable) {
    return localizedFacultyRepository.findAllByLocalizedId_Lang(lang, pageable);
  }

  @Override
  public Page<LocalizedInterest> findAllInterests(String lang, Pageable pageable) {
    return localizedInterestRepository.findAllByLocalizedId_Lang(lang, pageable);
  }

  @Override
  public UniversityResponseDto getUserUniversities() {
    return null;
  }
}
