package com.tasklist.TaskList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.tasklist.TaskList.domain.User;
import com.tasklist.TaskList.service.UserDetailsServiceimpl;

@Controller
public class DashBoardController {
	@Autowired 
		private UserDetailsServiceimpl userDetails;
	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap model) {
		userDetails.loadUserByUsername(user.getUsername());
		model.put("user", user);	
		return "dashboard";
	}
}
