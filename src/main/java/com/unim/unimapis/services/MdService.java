package com.unim.unimapis.services;

import com.unim.unimapis.dtos.md.UniversityResponseDto;
import com.unim.unimapis.models.LocalizedFaculty;
import com.unim.unimapis.models.LocalizedInterest;
import com.unim.unimapis.models.LocalizedUniversity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MdService {

  Page<LocalizedUniversity> findAllUniversities(String lang, Pageable pageable);

  Page<LocalizedFaculty> findAllFaculties(String lang, Pageable pageable);

  Page<LocalizedInterest> findAllInterests(String lang, Pageable pageable);

  UniversityResponseDto getUserUniversities();
}
