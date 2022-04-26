package com.tasklist.TaskList.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tasklist.TaskList.domain.User;

public class CustomSecurityUser extends User implements UserDetails	{

	private static final long serialVersionUID = 7371597053175471667L;
	
	public CustomSecurityUser() {}
	
	public CustomSecurityUser(User user) {
		
		this.setPassword(user.getPassword());
		this.setAuthorities(user.getAuthorities());
		this.setUserId(user.getUserId());
		this.setDepartment(user.getDepartment());
		this.setUsername(user.getUsername());
		this.setTasks(user.getTasks());
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}