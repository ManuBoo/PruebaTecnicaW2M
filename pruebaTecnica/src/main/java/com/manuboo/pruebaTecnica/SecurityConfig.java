package com.manuboo.pruebaTecnica;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .requestMatchers(HttpMethod.PUT, "/super-heroes/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/super-heroes/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
        .httpBasic()
            .and()
        .csrf().disable();

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withDefaultPasswordEncoder()
			.username("admin")
			.password("admin")
			.roles("ADMIN")
			.build();

		return new InMemoryUserDetailsManager(userDetails);
	}

}
	
