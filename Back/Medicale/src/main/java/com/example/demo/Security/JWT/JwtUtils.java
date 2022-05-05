package com.example.demo.Security.JWT;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import com.example.demo.Security.service.UserDetailsImpl;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
	
	 private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	 
	  @Value("${medical.app.jwtSecret}")
	  private String jwtSecret;
	  
	  @Value("${medical.app.jwtExpiration}")
	  private int jwtExpiration;
	  
	  @Value("${medical.app.jwtCookieName}")
	  private String jwtCookie;
	  
	  public String generateJwtToken(Authentication authentication) {
			UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
			return Jwts.builder()
					.setSubject((userPrincipal.getUsername()))
	                .setIssuedAt(new Date())
	                .setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000))
	                .signWith(SignatureAlgorithm.HS512, jwtSecret)
	                .compact();
		}
		
		
		public boolean validateJwtToken(String authToken) {
			try {
				Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
				return true;
			} catch (SignatureException e) {
				logger.error("Invalid JWT signature: {}", e.getMessage());
			} catch (MalformedJwtException e) {
				logger.error("Invalid JWT token: {}", e.getMessage());
			} catch (ExpiredJwtException e) {
				logger.error("JWT token is expired: {}", e.getMessage());
			} catch (UnsupportedJwtException e) {
				logger.error("JWT token is unsupported: {}", e.getMessage());
			} catch (IllegalArgumentException e) {
				logger.error("JWT claims string is empty: {}", e.getMessage());
			}
			return false;
		}
		public String getUserNameFromJwtToken(String token) {
			return Jwts.parser()
					.setSigningKey(jwtSecret)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
		}
	  public ResponseCookie getCleanJwtCookie() {
	    ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
	    return cookie;
	  }

}
