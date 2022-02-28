package com.tasklist.TaskList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tasklist.TaskList.domain.Authorities;
import com.tasklist.TaskList.domain.User;
import com.tasklist.TaskList.repository.AuthorityRepository;
import com.tasklist.TaskList.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AuthorityRepository authRepo;
	
	public void createUser(User user) {
		Authorities authority = new Authorities();
		authority.setUser(user);
		authority.setAuthority("ROLE_USER");
		user.setPassword(user.getPassword());
		user.setUsername(user.getUsername());
		user.setDepartment(user.getDepartment());
		user.getAuthorities().add(authority);
		userRepo.save(user);
		authRepo.save(authority);
		
		
	}

	public Boolean checkIfUserExists(String username) {
		if(userRepo.findByUsername(username) == null) {
			return true;
		}else {
			return false;
		}
				
	}

	public User findById(Long userId) {
		return userRepo.findByUserId(userId);
	}
	
		

}
