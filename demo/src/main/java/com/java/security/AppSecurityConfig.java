package com.java.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
				.antMatchers("/","/index","/css/*")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
	 UserDetails khanhUser=	User.builder()
				.username("khanh")
				.password("password")
				.roles("STUDENT")
				.build();
	 return new InMemoryUserDetailsManager(
			 	khanhUser
			 );
	}
}
