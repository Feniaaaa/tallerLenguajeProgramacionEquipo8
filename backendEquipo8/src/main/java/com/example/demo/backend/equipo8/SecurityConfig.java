package com.example.demo.backend.equipo8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	  @Autowired
	  private AppBasicAuthenticationEntryPoint authenticationEntryPoint;

	  
	  @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		  
	    http.csrf().disable().authorizeRequests()
	        .antMatchers(HttpMethod.GET		, "/boleta/**").permitAll()
	        .antMatchers(HttpMethod.POST	, "/boleta/**").permitAll()
	        .antMatchers(HttpMethod.PUT		, "/boleta/**").permitAll()
	        .antMatchers(HttpMethod.DELETE	, "/boleta/**").permitAll()
	        .antMatchers(HttpMethod.GET		, "/tipoboleta/**").permitAll()
	        .antMatchers(HttpMethod.POST	, "/tipoboleta/**").permitAll()
	        .antMatchers(HttpMethod.PUT		, "/tipoboleta/**").permitAll()
	        .antMatchers(HttpMethod.DELETE	, "/tipoboleta/**").permitAll()
	        .antMatchers(HttpMethod.GET		, "/proveedor/**").permitAll()
	        .antMatchers(HttpMethod.POST	, "/proveedor/**").permitAll()
	        .antMatchers(HttpMethod.PUT		, "/proveedor/**").permitAll()
	        .antMatchers(HttpMethod.DELETE	, "/proveedor/**").permitAll()
	        .antMatchers(HttpMethod.GET		, "/localidad/**").permitAll()
	        .antMatchers(HttpMethod.POST	, "/localidad/**").permitAll()
	        .antMatchers(HttpMethod.PUT		, "/localidad/**").permitAll()
	        .antMatchers(HttpMethod.DELETE	, "/localidad/**").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .httpBasic()
	        .authenticationEntryPoint(authenticationEntryPoint);
	    return http.build();
	  }

	  
	  
	  @Bean
	  public InMemoryUserDetailsManager userDetailsService() {

		  UserDetails admin = User
			        .withUsername("admin")
			        .password(passwordEncoder().encode("1234"))
			        .roles("ADMIN")
			        .build();
		  
		  UserDetails user = User
	        .withUsername("usuario")
	        .password(passwordEncoder().encode("4321"))
	        .roles("USER")
	        .build();

		  
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    manager.createUser(admin);
	    manager.createUser(user);
	    
	    return manager;
	  }

	  
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(8);
	  }
	
	
}
