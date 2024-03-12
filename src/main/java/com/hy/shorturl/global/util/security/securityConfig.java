package com.hy.shorturl.global.util.security;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class securityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.httpBasic(
				AbstractHttpConfigurer::disable
			)
			.csrf(
				AbstractHttpConfigurer::disable
			)
			.authorizeHttpRequests(
				auth -> auth.requestMatchers("/api/**").permitAll()
					.requestMatchers("/h2-console/**").permitAll()
					.requestMatchers("**").permitAll()
			);

		return http.build();
	}
}
