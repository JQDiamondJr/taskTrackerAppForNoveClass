package com.oosdclass.taskTrackerApp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Controller
public class TaskController {
	
	//Link the UI to the Service Layer
	@Autowired
	TaskService taskService;
	
	//GET: show the task view page - map viewTasks method to web page-for ADMIN
	@RequestMapping(value="/adminTask")
	public ModelAndView viewAdminTasks(ModelAndView model) {
		//map list of task to table in view page
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.setViewName("adminTask");
		return model;
	}
	//GET: show the task view page - for EMPLOYEES
	@RequestMapping(value="/empTasks")
	public ModelAndView viewEmpTasks(ModelAndView model) {
		//map list of task to table in view page
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.setViewName("empTask");
		return model;
	}
	//GET: show the admin only "create task" form
	@RequestMapping(value="/createTaskForm")
	public ModelAndView createTaskForm(ModelAndView model) {
		//map list of task to table in view page
		Task task = new Task();
		model.addObject(task);
		model.setViewName("createTask");
		return model;
	}
	//POST: post the newly created task to the DAO,
	//and then display the updated table in "view task" page
	@RequestMapping(value="/createTask", method = RequestMethod.POST)
	public ModelAndView createTasks(Task task) {
		ModelAndView model=null;
		taskService.saveTask(task);
		model = new ModelAndView("redirect:/adminTasks");
		return model;
	}
}
