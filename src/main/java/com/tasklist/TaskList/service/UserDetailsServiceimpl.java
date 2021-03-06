	package com.tasklist.TaskList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tasklist.TaskList.domain.User;
import com.tasklist.TaskList.dto.UserDto;
import com.tasklist.TaskList.repository.UserRepository;
import com.tasklist.TaskList.security.CustomSecurityUser;

@Service
public class UserDetailsServiceimpl implements UserDetailsService {
  
  @Autowired
  private UserRepository userRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    User user = userRepo.findByUsername(username);
    
    if (user == null)
      throw new UsernameNotFoundException("Username and or password was incorrect.");
    
    return new CustomSecurityUser(user);
  }
  
}