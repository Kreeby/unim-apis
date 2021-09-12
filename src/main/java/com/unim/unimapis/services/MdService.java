package com.unim.unimapis.services;

import com.unim.unimapis.dtos.md.UniversityResponseDto;
import java.util.List;

public interface MdService {

  List<UniversityResponseDto> findAllUniversities(String lang);
}
