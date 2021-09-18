package com.unim.unimapis.services.impl;

import com.unim.unimapis.models.LocalizedFaculty;
import com.unim.unimapis.models.LocalizedInterest;
import com.unim.unimapis.models.LocalizedUniversity;
import com.unim.unimapis.repository.LocalizedFacultyRepository;
import com.unim.unimapis.repository.LocalizedInterestRepository;
import com.unim.unimapis.repository.LocalizedUniversityRepository;
import com.unim.unimapis.services.MdService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MdServiceImpl implements MdService {

  LocalizedUniversityRepository localizedUniversityRepository;
  LocalizedFacultyRepository localizedFacultyRepository;
  LocalizedInterestRepository localizedInterestRepository;

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
}
