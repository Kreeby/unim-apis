package com.unim.unimapis.builders.entity;

import com.unim.unimapis.models.RoleEntity;
import com.unim.unimapis.models.UserEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserEntityBuilder {

  private final UserEntity userEntity;

  public UserEntityBuilder(UserEntity userEntity) {
    this.userEntity = userEntity;
  }

  public static UserEntityBuilder withBasicData() {
    RoleEntity roleEntity = new RoleEntity();
    roleEntity.setRoleName("ADMIN");
    roleEntity.setId(1);
    Set<RoleEntity> roleEntities = new HashSet<>();
    roleEntities.add(roleEntity);
    UserEntity userEntity = new UserEntity();
    userEntity.setHashedPassword("test");
    userEntity.setEnabled(true);
    userEntity.setEmailAddress("rashad.naghiyev@test.com");
    userEntity.setUserPostEntities(null);
    userEntity.setId(1);
    userEntity.setFirstName("Rashad");
    userEntity.setIntroText("Intro test");
    userEntity.setLastLogin(LocalDateTime.now());
    userEntity.setLastName("Naghiyev");
    userEntity.setMiddleName("Ramiz");
    userEntity.setPhoneNumber("testPhoneNumber");
    userEntity.setProfileText("Profile test");
    userEntity.setRegisteredAt(LocalDateTime.now());
    userEntity.setRoles(roleEntities);
    return new UserEntityBuilder(userEntity);
  }

  public UserEntity build() {
    return userEntity;
  }
}
