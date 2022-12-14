package com.giz.security1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("nimal")
		.password("nimal")
		.roles("USER")
		.and()
		.withUser("sahan")
		.password("sahan")
		.roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/report").hasRole("ADMIN")
		.antMatchers("/student").hasAnyRole("ADMIN","USER")
		.and()
		.formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
