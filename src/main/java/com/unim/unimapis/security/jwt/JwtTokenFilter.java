package com.unim.unimapis.security.jwt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

  final JwtTokenProvider jwtTokenProvider;

  @Override
  public void doFilter(ServletRequest servletRequest,
                       ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    String token = jwtTokenProvider.resolveToken((HttpServletRequest) servletRequest);

    if(token != null && jwtTokenProvider.validateToken(token)) {
      Authentication authentication = jwtTokenProvider.getAuthentication(token);
      if(authentication != null) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
