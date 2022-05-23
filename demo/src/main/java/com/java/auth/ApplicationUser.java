package com.java.auth;

<<<<<<< HEAD
import java.util.Set;
=======
import java.util.Collection;
import java.util.List;
>>>>>>> 3b9ad310c8b4e273570dd964c6492a0f8bb06ec6

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApplicationUser implements UserDetails{
<<<<<<< HEAD
	
	private final Set<? extends GrantedAuthority> grandauthorities;
=======

	private final List<? extends GrantedAuthority> grantedAuthorities;
>>>>>>> 3b9ad310c8b4e273570dd964c6492a0f8bb06ec6
	private final String password;
	private final String username;
	private final boolean isAccountNonExpired;
	private final boolean isAccountNonLocked;
	private final boolean isCredentialsNonExpired;
	private final boolean isEnabled;
<<<<<<< HEAD

	@Override
	public Set<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grandauthorities;
=======
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
>>>>>>> 3b9ad310c8b4e273570dd964c6492a0f8bb06ec6
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return password;
=======
		return null;
>>>>>>> 3b9ad310c8b4e273570dd964c6492a0f8bb06ec6
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return username;
=======
		return null;
>>>>>>> 3b9ad310c8b4e273570dd964c6492a0f8bb06ec6
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return isAccountNonExpired;
=======
		return false;
>>>>>>> 3b9ad310c8b4e273570dd964c6492a0f8bb06ec6
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return isAccountNonLocked;
=======
		return false;
>>>>>>> 3b9ad310c8b4e273570dd964c6492a0f8bb06ec6
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return isCredentialsNonExpired;
=======
		return false;
>>>>>>> 3b9ad310c8b4e273570dd964c6492a0f8bb06ec6
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return isEnabled;
=======
		return false;
>>>>>>> 3b9ad310c8b4e273570dd964c6492a0f8bb06ec6
	}
	
}
