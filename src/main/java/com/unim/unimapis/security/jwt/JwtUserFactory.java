package com.unim.unimapis.security.jwt;

import com.unim.unimapis.models.RoleEntity;
import com.unim.unimapis.models.UserEntity;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor
public final class JwtUserFactory {

  public static JwtUser create(UserEntity user) {
    return new JwtUser(
            user.getId(),
            user.getUsername(),
            user.getFirstName(),
            user.getMiddleName(),
            user.getLastName(),
            user.getHashedPassword(),
            user.getPhoneNumber(),
            user.getEmailAddress(),
            user.getLastLogin(),
            user.getIntroText(),
            user.getProfileText(),
            user.getEnabled(),
            user.getUserPostEntities(), mapGrantedAuthorities(new ArrayList<>(user.getRoles())));
  }

  private static Collection<? extends GrantedAuthority> mapGrantedAuthorities(ArrayList<RoleEntity> roleEntities) {
    return roleEntities
            .stream()
            .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getRoleName()))
            .collect(Collectors.toList());
  }
}
