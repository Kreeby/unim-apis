package com.unim.unimapis.security.jwt;

import com.unim.unimapis.models.UserPostEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtUser implements UserDetails {

  Integer id;
  String username;
  String firstName;
  String middleName;
  String lastName;
  String password;
  String phoneNumber;
  String emailAddress;
  LocalDateTime lastLogin;
  String introText;
  String profileText;
  Boolean enabled;
  Collection<UserPostEntity> userPostEntities;
  Collection<? extends GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public Integer getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public LocalDateTime getLastLogin() {
    return lastLogin;
  }

  public String getIntroText() {
    return introText;
  }

  public String getProfileText() {
    return profileText;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public Collection<UserPostEntity> getUserPostEntities() {
    return userPostEntities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
