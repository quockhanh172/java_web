package com.java.auth;

import java.util.Optional;

public interface ApplicationUserDao {
	public Optional<ApplicationUser> selecUserByUsername(String username);
}
