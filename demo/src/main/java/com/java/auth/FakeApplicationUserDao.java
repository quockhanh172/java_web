package com.java.auth;

import static com.java.security.ApplicatitonUserRole.STUDENT;
import static com.java.security.ApplicatitonUserRole.ADMIN;
import static com.java.security.ApplicatitonUserRole.ADMINTRAINEE;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository("fake")
public class FakeApplicationUserDao implements ApplicationUserDao {
	
	private final PasswordEncoder passwordEncoder;

	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		// TODO Auto-generated method stub
		return getApplicationUsers().stream().filter(applicationUser-> username.equals(applicationUser.getUsername())).findFirst();
	}
	
	private List<ApplicationUser> getApplicationUsers(){
		List<ApplicationUser> applicationUsers = Lists.newArrayList(
				new ApplicationUser(STUDENT.getGrantedAuthoritiers(), 
									passwordEncoder.encode("password"), 
									"khanh", 
									true, 
									true, 
									true, 
									true),
				
				new ApplicationUser(ADMIN.getGrantedAuthoritiers(), 
						passwordEncoder.encode("password"), 
						"trang", 
						true, 
						true, 
						true, 
						true),
				
				new ApplicationUser(ADMINTRAINEE.getGrantedAuthoritiers(), 
						passwordEncoder.encode("password"), 
						"tom", 
						true, 
						true, 
						true, 
						true)
		);
		return applicationUsers;
	}
}
