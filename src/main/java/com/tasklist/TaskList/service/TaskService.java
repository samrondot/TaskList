package com.tasklist.TaskList.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tasklist.TaskList.domain.Task;
import com.tasklist.TaskList.domain.User;
import com.tasklist.TaskList.repository.TaskRepository;
import com.tasklist.TaskList.repository.UserRepository;

@Service
public class TaskService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TaskRepository taskRepo;

	public void createTask(Task task, User user) {
		LocalDate rightNow = LocalDate.now();
		task.setDetailDate(rightNow);
		task.setUser(user);
		user.getTasks().add(task);
		userRepo.save(user);
	}

	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

	public Task findById(Long taskId) {
		return taskRepo.getById(taskId);
	}

	public void saveTask(Task task) {
		taskRepo.save(task);
		
	}

	public void delete(Long taskId, Long userId) {
		
		Task task = taskRepo.findByTaskId(taskId);
		User user = userRepo.findByUserId(userId);
		if(user.getDepartment().equals(task.getAssignedDept())) {
			taskRepo.delete(task);
		}else {
			System.out.println(user.getDepartment() + " does not equal " + task.getAssignedDept());
		}
		
		
		
	}

	
	
}
