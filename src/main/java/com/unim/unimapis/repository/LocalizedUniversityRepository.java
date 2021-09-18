package com.unim.unimapis.repository;

import com.unim.unimapis.models.LocalizedUniversity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizedUniversityRepository extends JpaRepository<LocalizedUniversity, Integer> {
  Page<LocalizedUniversity> findAllByLocalizedId_Lang(String lang, Pageable pageable);
}
