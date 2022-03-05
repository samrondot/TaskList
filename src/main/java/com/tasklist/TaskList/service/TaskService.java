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
		Task newTask = new Task();	
		LocalDate rightNow = LocalDate.now();
		newTask.setAssignedDept(task.getAssignedDept());
		newTask.setDetailDate(rightNow);
		newTask.setDetails(task.getDetails());
		newTask.setUser(user);
		user.getTasks().add(newTask);
		userRepo.save(user);
		taskRepo.save(newTask);
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
		System.out.println(task);
		taskRepo.delete(task);
		
		
	}

	
	
}
