package com.tasklist.TaskList.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {

	@JsonProperty("message")
	private String message;
	@JsonProperty("user")
	private String user;
	@JsonProperty("taskId")
	private Long taskId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	
	
}
