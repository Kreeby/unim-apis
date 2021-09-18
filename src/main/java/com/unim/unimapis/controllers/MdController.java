package com.unim.unimapis.controllers;

import com.unim.unimapis.models.LocalizedFaculty;
import com.unim.unimapis.models.LocalizedInterest;
import com.unim.unimapis.models.LocalizedUniversity;
import com.unim.unimapis.services.MdService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequestMapping("/api/v1/md")
public class MdController {
  MdService mdService;

  @GetMapping("/universities")
  public ResponseEntity<Page<LocalizedUniversity>> findAllUniversities(@RequestParam String lang, Pageable pageable) {
    return ResponseEntity.ok(mdService.findAllUniversities(lang, pageable));
  }

  @GetMapping("/faculties")
  public ResponseEntity<Page<LocalizedFaculty>> findAllFaculties(@RequestParam String lang, Pageable pageable) {
    return ResponseEntity.ok(mdService.findAllFaculties(lang, pageable));
  }

  @GetMapping("/interests")
  public ResponseEntity<Page<LocalizedInterest>> findAllInterests(@RequestParam String lang, Pageable pageable) {
    return ResponseEntity.ok(mdService.findAllInterests(lang, pageable));
  }

}
