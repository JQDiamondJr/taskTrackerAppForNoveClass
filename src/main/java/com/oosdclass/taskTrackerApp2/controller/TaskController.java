package com.oosdclass.taskTrackerApp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Controller
public class TaskController {

	// Link the UI to the Service layer
	@Autowired
	TaskService taskService;

	// GET: show the task view page - map viewTasks method to web page - for ADMIN
	@RequestMapping(value = "/adminTask")
	public ModelAndView viewAdminTask(ModelAndView model) {
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.setViewName("adminTask");
		return model;
	}

	// GET: show the task view page - for EMPLOYEES
	@RequestMapping(value = "/empTask/{username}")
	public ModelAndView viewEmpTask(ModelAndView model, @PathVariable String username) {
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.addObject(username);
		model.setViewName("empTask");
		return model;
	}

	// GET: show the admin only "create task" form
	@RequestMapping(value = "/createTaskForm")
	public ModelAndView createTaskForm(ModelAndView model) {
		// map create task form in the view page
		Task task = new Task();
		model.addObject(task);
		model.setViewName("createTask");
		return model;
	}

	// this method posts the newly created task to the db and then redirects to the
	// admin tasks page
	@RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public ModelAndView createTask(Task task) {
		ModelAndView model = null;
		taskService.saveTask(task);
		model = new ModelAndView("redirect:/adminTask");
		return model;
	}

	// when you click on the task id hyperlink in the emptasks page this method gets
	// called
	@RequestMapping(value = "/viewTask/{taskID}/{username}")
	public ModelAndView viewTask(ModelAndView model, @PathVariable int taskID, @PathVariable String username) {
		Task task = taskService.getTaskById(taskID);
		model.addObject(task);
		model.addObject(username);
		model.setViewName("viewTask");
		return model;
	}

	// From View Task page: Button: ASSIGN TO ME - reroute to empTasks
	@RequestMapping(value = "/updateTask/{status}/{taskID}/{username}", method = RequestMethod.GET)
	// use @PathVariable to pull variables from URL/use them as values for updated
	// attributes
	public ModelAndView updateStatus(@PathVariable int taskID, @PathVariable String status,
			@PathVariable String username) {
		ModelAndView model = null;
		taskService.updateTaskStatus(taskID, status, username);
		model = new ModelAndView("redirect:/empTask/{username}");
		return model;
	}

	// This method is called when the assign to me button is clicked on the
	@RequestMapping(value = "/updateTask/ASSIGN/{taskID}/{username}", method = RequestMethod.GET)
	public ModelAndView updateAssignedTo(@PathVariable int taskID, @PathVariable String username) {
		ModelAndView model = null;
		taskService.updateTaskAssignedTo(taskID, username);
		model = new ModelAndView("redirect:/empTask/{username}");
		return model;
	}

	@RequestMapping(value = "/deleteTask/{taskID}", method = RequestMethod.GET)
	public ModelAndView deleteTask(@PathVariable int taskID) {
		ModelAndView model = null;
		taskService.deleteTask(taskID);
		model = new ModelAndView("redirect:/adminTask");
		return model;
	}
}
