package com.tasklist.TaskList.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskDto {
	@JsonProperty("username")
	private String username;
	@JsonProperty("taskId")
	private Long taskId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	

}
