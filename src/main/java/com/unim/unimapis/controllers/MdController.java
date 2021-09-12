package com.unim.unimapis.controllers;

import com.unim.unimapis.dtos.md.UniversityResponseDto;
import com.unim.unimapis.services.MdService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequestMapping("/api/v1/md")
public class MdController {
  MdService mdService;

  @GetMapping("/universities")
  public ResponseEntity<List<UniversityResponseDto>> findAllUniversities(@RequestParam String lang) {
    return ResponseEntity.ok(mdService.findAllUniversities(lang));
  }
}
