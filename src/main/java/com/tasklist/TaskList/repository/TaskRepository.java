package com.tasklist.TaskList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tasklist.TaskList.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	Task findByTaskId(Long taskId);
}
