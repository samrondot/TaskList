package com.tasklist.TaskList.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tasklist.TaskList.domain.Task;
import com.tasklist.TaskList.domain.User;
import com.tasklist.TaskList.service.TaskService;
import com.tasklist.TaskList.service.UserDetailsServiceimpl;
import com.tasklist.TaskList.service.UserService;

@Controller
public class DashBoardController {
	@Autowired 
		private UserDetailsServiceimpl userDetails;
	@Autowired
		private TaskService taskService;
	@Autowired
		private UserService userService;
	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap model) {
		userDetails.loadUserByUsername(user.getUsername());
		List<Task> allTasks = taskService.getAllTasks();
		model.put("user", user);
		model.put("tasks", allTasks);
		return "dashboard";
	}
	@GetMapping("/viewTask/{userId}/{taskId}")
	public String getTask(ModelMap model, @PathVariable Long userId, @PathVariable Long taskId) {
		User user = userService.findById(userId);
		Task task = taskService.findById(taskId);
		model.put("user", user);
		model.put("task", task);
		
		return "viewTask";
		
	}
}
