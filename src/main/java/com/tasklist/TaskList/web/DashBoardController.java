package com.tasklist.TaskList.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.tasklist.TaskList.domain.User;

@Controller
public class DashBoardController {
	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap model) {
		model.put("user", user);	
		return "dashboard";
	}
}
