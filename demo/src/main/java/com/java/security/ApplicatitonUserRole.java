package com.java.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

import lombok.RequiredArgsConstructor;

import static com.java.security.ApplicationUserPermission.*;
@RequiredArgsConstructor
public enum ApplicatitonUserRole {
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
	ADMINTRAINEE(Sets.newHashSet(COURSE_READ,STUDENT_READ));

	private final Set<ApplicationUserPermission> permissions;

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthoritiers(){
				Set<SimpleGrantedAuthority> permissions =	getPermissions().stream()
						.map(permission->new SimpleGrantedAuthority(permission.getPermission()))
						.collect(Collectors.toSet());
				permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
				return permissions;
	}
}
