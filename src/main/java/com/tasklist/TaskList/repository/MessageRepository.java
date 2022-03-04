package com.tasklist.TaskList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tasklist.TaskList.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	@Query(value ="SELECT * FROM MESSAGES WHERE task_Id = ?", nativeQuery = true)
	List<Message> findAllBytaskId(Long taskId);

}
