package com.tasklist.TaskList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tasklist.TaskList.domain.User;
import com.tasklist.TaskList.service.UserDetailsServiceimpl;
import com.tasklist.TaskList.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	
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
		return "redirect:/login";
	}
	
	@PostMapping("/exists")
	@ResponseBody
	public Boolean postExists (@RequestAttribute User user) {
		System.out.println("hello");
		user = userService.findByUsername(user.getUsername());
		return (user != null);
	}
}
