package com.tasklist.TaskList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tasklist.TaskList.domain.Task;
import com.tasklist.TaskList.domain.User;
import com.tasklist.TaskList.dto.UserDto;
import com.tasklist.TaskList.service.TaskService;
import com.tasklist.TaskList.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/login")
	public String login () {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(User user) {
		userService.createUser(user);
		System.out.println(user.getDepartment());
		return "redirect:/login";
	}
	
	@PostMapping("/exists")
	@ResponseBody
	public Boolean postExists (@RequestBody UserDto user) {
		UserDto userDto = new UserDto();
		userDto.setPassword(user.getPassword());
		userDto.setUsername(user.getUsername());
		System.out.println(userService.checkIfUserExists(userDto.getUsername()));
		return(userService.checkIfUserExists(userDto.getUsername()));
		
	}
	@GetMapping("/createTask/{userId}")
	public String createNewTask(@PathVariable Long userId, ModelMap model) {
		Task task = new Task();
		User user = userService.findById(userId);
		model.put("task", task);
		model.put("user", user);
		return "newtask";
	}
	@PostMapping("/createTask")
	public String createNewTask( User user, Task task) {
		taskService.createTask(task, user);
		return "redirect:/dashboard";
	
	
	}
}