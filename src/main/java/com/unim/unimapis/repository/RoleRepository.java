package com.unim.unimapis.repository;

import com.unim.unimapis.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
  Optional<List<RoleEntity>> findAllByRoleName(String name);
}
