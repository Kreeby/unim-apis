package com.unim.unimapis.services;

import com.unim.unimapis.dtos.md.FacultyResponseDto;
import com.unim.unimapis.dtos.md.InterestResponseDto;
import com.unim.unimapis.dtos.md.UniversityResponseDto;
import java.util.List;

public interface MdService {

  List<UniversityResponseDto> findAllUniversities(String lang);

  List<FacultyResponseDto> findAllFaculties(String lang);

  List<InterestResponseDto> findAllInterests(String lang);
}
