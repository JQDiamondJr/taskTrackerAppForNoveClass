package com.oosdclass.taskTrackerApp2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;

@Controller
public class TaskController {
	
	@RequestMapping(value="/adminTask")
	public ModelAndView viewTasks(ModelAndView model) {
		
		List<Task> taskList = mockServiceTasks();
		model.addObject(taskList);
		model.setViewName("viewTask");
		return model;
	}
	
	public List<Task> mockServiceTasks() {
		Task task1 = new Task();
		Task task2 = new Task();
		
		task1.setTaskID(1);
		task1.setDescription("update model");
		task1.setStatus("OPEN");
		task1.setAssignedTo("Ed");
		
		task2.setTaskID(2);
		task2.setDescription("create POJO");
		task2.setStatus("OPEN");
		task2.setAssignedTo("Adil");
		
		List<Task> taskList = new ArrayList<Task>();
		taskList.add(task1);
		taskList.add(task2);
		
		return taskList;
	}

}
