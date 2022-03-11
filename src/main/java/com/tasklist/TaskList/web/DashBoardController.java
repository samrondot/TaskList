package com.tasklist.TaskList.web;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tasklist.TaskList.domain.Message;
import com.tasklist.TaskList.domain.Task;
import com.tasklist.TaskList.domain.User;
import com.tasklist.TaskList.dto.MessageDto;
import com.tasklist.TaskList.dto.TaskDto;
import com.tasklist.TaskList.service.MessageService;
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
	@Autowired
		private MessageService messageService;
	
	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap model) {
		userDetails.loadUserByUsername(user.getUsername());
		List<Task> allTasks = taskService.getAllTasks();
		model.put("user", user);
		model.put("tasks", allTasks);
		return "dashboard";
	
	}
	@GetMapping("/viewTask/{userId}/{taskId}")
	public String getTask(ModelMap model, @PathVariable Long taskId) {
		Task task = taskService.findById(taskId);
		User user = task.getUser();
		Message message = new Message();
		model.put("task", task);
		model.put("user", user);
		model.put("message", message);
		return "viewTask";
	}
	@ResponseBody
	@PostMapping("/messageSent")
		private void messageReceived (@RequestBody MessageDto message) {
		messageService.createMessage(message);
	}
	@ResponseBody
	@PostMapping("/obtainMessages/{taskId}")
		private List<MessageDto> obtainMessages(@PathVariable Long taskId) {
		return messageService.getMessageBytaskId(taskId);
		
	}	
	@ResponseBody
	@PostMapping("/matchDepartment")
		private Boolean matchesDepartment(@RequestBody TaskDto taskDto) {
			Task task = taskService.findById(taskDto.getTaskId());
			User user = userService.findById(task.getUser().getUserId());
			if(task.getAssignedDept().equals(user.getDepartment())) {
				taskService.delete(task.getTaskId(), user.getUserId());
				return true;
			}else {
				return false;
			}
}

	
}