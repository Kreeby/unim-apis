package com.unim.unimapis.repository;

import com.unim.unimapis.models.LocalizedInterest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizedInterestRepository extends JpaRepository<LocalizedInterest, Integer> {
  Page<LocalizedInterest> findAllByLocalizedId_Lang(String lang, Pageable pageable);
}
