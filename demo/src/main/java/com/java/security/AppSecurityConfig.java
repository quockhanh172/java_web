package com.java.security;

import static com.java.security.ApplicationUserPermission.COURSE_WRITE;
import static com.java.security.ApplicatitonUserRole.ADMIN;
import static com.java.security.ApplicatitonUserRole.ADMINTRAINEE;
import static com.java.security.ApplicatitonUserRole.STUDENT;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/","/index","/css/*").permitAll()
				.antMatchers("/api/**").hasRole(STUDENT.name())
				.antMatchers(HttpMethod.DELETE,"/managerment/api/**").hasAuthority(COURSE_WRITE.getPermission()) 
				.antMatchers(HttpMethod.POST,"/managerment/api/**").hasAuthority(COURSE_WRITE.getPermission())
				.antMatchers(HttpMethod.PUT,"/managerment/api/**").hasAuthority(COURSE_WRITE.getPermission())
				.antMatchers(HttpMethod.GET,"/managerment/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/course",true)
				.and()
				.rememberMe()
					.tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
					.key("somethingverysecure")
				.and()
				.logout()
				.logoutUrl("/logout")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID","remember-me")
				.logoutSuccessUrl("/login");
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
	 UserDetails khanhUser=	User.builder()
				.username("khanh")
				.password(passwordEncoder.encode("password"))
				.authorities(STUDENT.getGrantedAuthoritiers())
				/*
				 * .roles(STUDENT.name()) //role student
				 */				.build();
	 
	 UserDetails trangUser=	User.builder()
				.username("trang")
				.password(passwordEncoder.encode("password"))
				.authorities(ADMIN.getGrantedAuthoritiers())
				/*
				 * .roles(ADMIN.name()) //role student
				 */				.build();
	 
	 UserDetails tomUser=	User.builder()
				.username("tom")
				.password(passwordEncoder.encode("password"))
				.authorities(ADMINTRAINEE.getGrantedAuthoritiers())
				/*
				 * .roles(ADMINTRAINEE.name()) //role student
				 */				.build();
	 
	 return new InMemoryUserDetailsManager(
			 	khanhUser,
			 	trangUser,
			 	tomUser
			 );
	}
}
