package com.tasklist.TaskList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasklist.TaskList.domain.Message;
import com.tasklist.TaskList.domain.Task;
import com.tasklist.TaskList.domain.User;
import com.tasklist.TaskList.dto.MessageDto;
import com.tasklist.TaskList.repository.MessageRepository;
import com.tasklist.TaskList.repository.UserRepository;

@Service
public class MessageService {
@Autowired
private MessageRepository messageRepo;
@Autowired
private UserService userService;
@Autowired
private TaskService taskService;
@Autowired
private UserRepository userRepo;
	
	public void createMessage(MessageDto message) {
		Message newMessage = new Message();
		Task task = taskService.findById(message.getTaskId());
		User user = userService.findById(message.getUserId());
		user.getMessages().add(newMessage);
		newMessage.setMessageContent(message.getMessage());
		newMessage.setUser(user);
		newMessage.setTask(task);
		userRepo.save(user);
	}

	public List<MessageDto> getMessageBytaskId(Long taskId) {
		List<Message> messageList = messageRepo.findAllBytaskId(taskId);
		List<MessageDto> messagesDto = new ArrayList<>();
		for (Message message:messageList) {
			MessageDto messageDto = new MessageDto();
			User user = message.getUser();
			messageDto.setTaskId(message.getTask().getTaskId());
			messageDto.setMessage(message.getMessageContent());
			messageDto.setUser(user.getUsername());
			messagesDto.add(messageDto);
		}
		return messagesDto;
	}
}
