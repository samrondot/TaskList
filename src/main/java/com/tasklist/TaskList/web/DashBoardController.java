package com.tasklist.TaskList.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
	@GetMapping("/dashboard")
	public String getDashboard() {
		return "dashboard";
	}
}
