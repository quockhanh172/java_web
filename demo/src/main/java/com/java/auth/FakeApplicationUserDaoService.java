package com.java.auth;

import static com.java.security.ApplicatitonUserRole.ADMIN;
import static com.java.security.ApplicatitonUserRole.STUDENT;
import static com.java.security.ApplicatitonUserRole.ADMINTRAINEE;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
	private final PasswordEncoder passwordEncoder;

	@Override
	public Optional<ApplicationUser> selecUserByUsername(String username) {
		// TODO Auto-generated method stub
		return getApplicationUsers().stream().filter(user-> username.equals(user.getUsername())).findFirst();
	}
	
	
	public List<ApplicationUser> getApplicationUsers(){
		List<ApplicationUser> users = Lists.newArrayList(
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
		return users;
	}
}
