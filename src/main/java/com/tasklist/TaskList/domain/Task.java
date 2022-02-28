package com.tasklist.TaskList.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	private Long taskId;
	private String details;
	private LocalDateTime detailDate;
	private String assignedDept;
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDateTime getDetailDate() {
		return detailDate;
	}
	public void setDetailDate(LocalDateTime detailDate) {
		this.detailDate = detailDate;
		
	}
	public String getAssignedDept() {
		return assignedDept;
	}
	public void setAssignedDept(String assignedDept) {
		this.assignedDept = assignedDept;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
