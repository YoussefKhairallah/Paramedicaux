package com.example.demo.Security.JWT;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.demo.Security.service.UserDetailsServiceImpl;



public class AuthTokenFilte extends OncePerRequestFilter {
	  @Autowired
	  private JwtUtils jwtUtils;
	  @Autowired
	  private UserDetailsServiceImpl userDetailsService;
	  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilte.class);
	  @Override
	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	      throws ServletException, IOException {
	    try {
	      String jwt = parseJwt(request);
	      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
	        String Nom = jwtUtils.getUserNameFromJwtToken(jwt);
	        UserDetails user = userDetailsService.loadUserByUsername(Nom);
	        
	        UsernamePasswordAuthenticationToken authentication = 
	            new UsernamePasswordAuthenticationToken(user,
	                                                    null,
	                                                    user.getAuthorities());
	        
	        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	      }
	    } catch (Exception e) {
	      logger.error("Cannot set user authentication: {}", e);
	    }
	    filterChain.doFilter(request, response);
	  }
	  private String parseJwt(HttpServletRequest request) {
	    String jwt = jwtUtils.getJwtFromCookies(request);
	    return jwt;
	  }
	}
