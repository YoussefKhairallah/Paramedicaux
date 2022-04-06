package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import com.example.demo.Security.JWT.AuthEntryPointJwt;
import com.example.demo.Security.JWT.AuthTokenFilte;
import com.example.demo.Security.service.UserDetailsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    //securedEnabled = true,
    //jsr250Enabled = true,
    prePostEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Value("${spring.h2.console.path}")
	  private String h2ConsolePath;
	 @Autowired
	  UserDetailsServiceImpl userDetailsService;
	 @Autowired
	  private AuthEntryPointJwt unauthorizedHandler;
	 @Bean
	  public AuthTokenFilte authenticationJwtTokenFilter() {
	    return new AuthTokenFilte();
	  }
	  @Override
	  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	  }
	  @Bean
	  @Override
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	  }
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.cors().and().csrf().disable()
	      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	      .authorizeRequests().antMatchers("/api/auth/**").permitAll()
	      .antMatchers("/api/test/**").permitAll()
	      .antMatchers(h2ConsolePath + "/**").permitAll()
	      .anyRequest().authenticated();
	     // making H2 console working
	        http.headers().frameOptions().disable();
	        http.authorizeRequests();

	    // fix H2 database console: Refused to display ' in a frame because it set 'X-Frame-Options' to 'deny'
	    http.headers().frameOptions().sameOrigin();
	    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	  }
}
