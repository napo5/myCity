package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import app.model.Report;
import app.model.Task;
import app.service.ReportService;
import app.service.TaskService;

@Controller
public class TaskController {

	private final ReportService reportService;
	private final TaskService taskService;
	
	@Autowired
	public TaskController(ReportService reportService, TaskService taskService) {
		this.reportService = reportService;
		this.taskService = taskService;
	}
	
	@RequestMapping(value = "/newTask/{idReport}", method = RequestMethod.POST)
	public String newTask(@PathVariable("idReport") String idReport, Model model,@ModelAttribute Task task) {
		Long x = Long.valueOf(idReport);
		

		Report target = reportService.getReport(x).get();
		task.setReport(target);
		taskService.createTask(task);
		target.setTask(task);
		reportService.createReport(target);
		model.addAttribute("reports", reportService.getAllReport());
		return "reportResult";
	}
	
	@RequestMapping(value = "/newTaskPage/{idReport}", method = RequestMethod.GET)
	public String newTaskPage(@PathVariable("idReport") String idReport, Model model) {
		Long x = Long.valueOf(idReport);
		if (reportService.getReport(x).isPresent()) {
			if (reportService.getReport(x).get().hasTask()) {
				return "error";
			}
		} else return "error";
		model.addAttribute("task", new Task());
		model.addAttribute("idReport", idReport );
		return "newTask";
	}
	
	@RequestMapping(value = "/allTask", method = RequestMethod.GET)
	public String allTask(Model model) {
		model.addAttribute("tasks",taskService.getAllTasks());
		return "allTask";
	}
	
	
	
}
