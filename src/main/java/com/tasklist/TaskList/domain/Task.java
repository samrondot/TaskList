package com.tasklist.TaskList.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Task {
	private Long taskId;
	private String details;
	private LocalDate detailDate;
	private String assignedDept;
	private List<Message> messages;
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
	public LocalDate getDetailDate() {
		return detailDate;
	}
	public void setDetailDate(LocalDate detailDate) {
		this.detailDate = detailDate;
		
	}
	public String getAssignedDept() {
		return assignedDept;
	}
	public void setAssignedDept(String assignedDept) {
		this.assignedDept = assignedDept;
	
	}
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
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
