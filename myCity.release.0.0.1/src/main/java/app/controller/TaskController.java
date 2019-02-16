package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.model.Person;
import app.model.Report;
import app.model.Task;
import app.service.PersonService;
import app.service.ReportService;
import app.service.TaskService;

@Controller
public class TaskController {

	private final ReportService reportService;
	private final TaskService taskService;
	private final PersonService personService;
	
	@Autowired
	public TaskController(ReportService reportService, TaskService taskService, PersonService personService) {
		this.reportService = reportService;
		this.taskService = taskService;
		this.personService = personService;
	}
	//create a new task;
	@RequestMapping(value = "/newTask/{idReport}", method = RequestMethod.POST)
	public String newTask(@PathVariable("idReport") String idReport,HttpServletRequest request, Model model,@ModelAttribute Task task) {
		Long x = Long.valueOf(idReport);
		Report target = reportService.getReport(x).get();
		target.setState(Report.inattesadicandidature);
		task.setReport(target);
		task.setState(Report.inattesadicandidature);
		taskService.createTask(task);
		target.setTask(task);
		reportService.createReport(target);
		model.addAttribute("reports", reportService.getAllReport());
		String cookie = CallbackController.getCookie(request);
		model.addAttribute("role",personService.getPersonByCookie(cookie).getRole());
		return "allReports";
	}
	
	//prepare for creating a new task;
	@RequestMapping(value = "/newTaskPage/{idReport}", method = RequestMethod.GET)
	public String newTaskPage(@PathVariable("idReport") String idReport, Model model) {
		Long x = Long.valueOf(idReport);
		if (reportService.getReportNoOpt(x) != null) {
			if (reportService.getReport(x).get().hasTask()) {
				return "Error! There is already a Task for this Report!";
			}
		} else return "Error! Report not found!";
		model.addAttribute("task", new Task());
		model.addAttribute("idReport", idReport );
		return "newTask";
	}
	//get a particular task from his id;
	@RequestMapping(value = "/getTask/{idReport}", method = RequestMethod.GET)
	public String getTaskById(@PathVariable("idReport") String idReport,Model model,HttpServletRequest request) {
		Long x = Long.valueOf(idReport);
		String cookie = CallbackController.getCookie(request);
		Person person= personService.getPersonByCookie(cookie);
		model.addAttribute("role",person.getRole());
		model.addAttribute("task",taskService.getTaskByReportId(x));
		return "seeTask";
	}
	//get all tasks of a particular person;
	@RequestMapping(value = "/seeMyTasks/{idPerson}", method = RequestMethod.GET)
	public String seeMyTasks(@PathVariable("idPerson") String idPerson,Model model) {
		Long x = Long.valueOf(idPerson);
		model.addAttribute("tasks",taskService.getTasksByWorkerId(x));
		return "allTask";
	}
	
	
	
}
