package com.oosdclass.taskTrackerApp2.service;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskService {

	List<Task> getAllTask();

	public void saveTask(Task task);

	Task getTaskById(int taskId);

	public void updateTaskStatus(int taskID, String status, String username);

	public void updateTaskAssignedTo(int taskID, String username);

	void deleteTask(int taskID);

}
