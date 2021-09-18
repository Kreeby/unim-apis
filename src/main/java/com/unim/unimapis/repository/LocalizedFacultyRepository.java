package com.unim.unimapis.repository;

import com.unim.unimapis.models.LocalizedFaculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizedFacultyRepository extends JpaRepository<LocalizedFaculty, Integer> {
  Page<LocalizedFaculty> findAllByLocalizedId_Lang(String lang, Pageable pageable);
}
