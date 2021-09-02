package com.unim.unimapis.config;

import com.unim.unimapis.security.jwt.JwtTokenConfigurer;
import com.unim.unimapis.security.jwt.JwtTokenProvider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;


@AllArgsConstructor
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  JwtTokenProvider jwtTokenProvider;

  static String LOGIN_ENDPOINT = "/api/v1/auth/login";
  static String REGISTER_ENDPOINT = "/api/v1/auth/register";
  static String ADMIN_ENDPOINT = "/api/v1/admin/**";
  static String MESSAGE_ENDPOINT = "/chat";

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  GrantedAuthorityDefaults grantedAuthorityDefaults() {
    return new GrantedAuthorityDefaults("");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .httpBasic().disable()
            .csrf().disable()
            .cors().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(LOGIN_ENDPOINT, REGISTER_ENDPOINT).permitAll()
            .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
            .antMatchers(MESSAGE_ENDPOINT).hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()
            .and()
            .apply(new JwtTokenConfigurer(jwtTokenProvider));
  }
}
