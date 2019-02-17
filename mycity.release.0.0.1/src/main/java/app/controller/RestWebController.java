package app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.AcceptRefuseTaskRequestBody;
import app.model.AddCommentRequestBody;
import app.model.Candidature;
import app.model.Comment;
import app.model.Message;
import app.model.Person;
import app.model.Report;
import app.model.Response;
import app.model.Task;
import app.model.createReportRequestBody;
import app.service.CandidatureService;
import app.service.CommentService;
import app.service.MessageService;
import app.service.PersonService;
import app.service.ReportService;
import app.service.TaskService;


@RestController
@RequestMapping("/api")
public class RestWebController {

	List<AddCommentRequestBody> protoList = new ArrayList<AddCommentRequestBody>();
	private final ReportService reportService;
	private final CommentService commentService;
	private final PersonService personService;
	private final CandidatureService candidatureService;
	private final MessageService messageService;
	private final TaskService taskService;

	@Autowired
	public RestWebController(ReportService reportService, CommentService commentService, PersonService personService, CandidatureService candidatureService, MessageService messageService, TaskService taskService) {
		this.reportService = reportService;
		this.commentService = commentService;
		this.personService = personService;
		this.candidatureService = candidatureService;
		this.messageService = messageService;
		this.taskService = taskService;
	}
		
	//add a comment;
	@PostMapping(value = "/addComment/{idReport}")
	public Response addComment(@RequestBody AddCommentRequestBody requestBody,@PathVariable("idReport") String idReport,HttpServletRequest request) {
		protoList.add(requestBody);
		Long x = Long.valueOf(idReport);
		Comment comment = new Comment(requestBody.getDescription());
		String cookie = CallbackController.getCookie(request);
		Person author = personService.getPersonByCookie(cookie);
		comment.setAuthor(author.getName());
		Report target = reportService.getReport(x).get();
		comment.setReport(target);
		commentService.createComment(comment);
		target.addComment(comment);
		reportService.createReport(target);
		return new Response("Done", protoList);
	}
	//create a new report;
	@PostMapping(value = "/createReport")
	public Response createReport(@RequestBody createReportRequestBody requestBody,HttpServletRequest request) {
		String cookie = CallbackController.getCookie(request);
		Person author = personService.getPersonByCookie(cookie);
		Report report = new Report();
		report.setDescription(requestBody.getDescription());
		report.setTitle(requestBody.getTitle());
		report.setImage(requestBody.getImage());
		report.setAuthor(author);
		report.setState(Report.inattesa);
		reportService.createReport(report);
		Response response = new Response("Done", requestBody);
		return response;
	}
	//sends the candidature for a particular task;
	@PostMapping(value = "/applyForTask/{idReport}")
	public Response applyForTask(@RequestBody AddCommentRequestBody requestBody,@PathVariable("idReport") String idReport,HttpServletRequest request) {
		Long x = Long.valueOf(idReport);
		Report target = reportService.getReport(x).get();
		Task task = target.getTask();
		String cookie = CallbackController.getCookie(request);
		Person author = personService.getPersonByCookie(cookie);
		if ((candidatureService.findUnique(author, reportService.getReportNoOpt(x).getTask()) == null) & reportService.getReportNoOpt(x).getTask() != null) {
		Candidature candidature = new Candidature();
		candidature.setPeople(author);
		candidature.setTasks(task);
		candidatureService.createCandidature(candidature);
		Response response = new Response("Done", null);
		return response;
		} 		
		Response response = new Response("Fail", null);
		return response;
	}
	
	//the cityadmin send the request to be the selected worker for that task, to a user
	@PostMapping(value = "/sendTaskRequest/{idPerson}/{idReport}")
	public Response sendTaskRequest(@PathVariable(value="idPerson")String idPerson,@PathVariable(value="idReport")String idReport, HttpServletRequest request) {
		Long x = Long.valueOf(idPerson);
		if(personService.getPersonNoOpt(x) != null){
		Message message = new Message();
		message.setDescription("Sei stato scelto per questo Task!");
		message.setOwner(personService.getPersonNoOpt(x));
		message.setSenderName(personService.getPersonNoOpt(x).getName());
		message.setSenderSurname(personService.getPersonNoOpt(x).getSurname());
		message.setSenderRole(personService.getPersonNoOpt(x).getRole());
		message.setIdReport(idReport);
		message.setRead(false);
		messageService.createMessage(message);
		String workerChoosenName = personService.getPersonNoOpt(x).getName();
		workerChoosenName = workerChoosenName + " " + personService.getPersonNoOpt(x).getSurname();
		return new Response("Done", workerChoosenName);
		} else return new Response("Fail", null);
	}
	//a user can accept or refuse a task request;
	@PostMapping(value = "/acceptRefuseTask")
	public Response acceptRefuseTask(@RequestBody AcceptRefuseTaskRequestBody requestBody,HttpServletRequest request) {
		Long x = Long.valueOf(requestBody.getIdReport());
		Long z = Long.valueOf(requestBody.getIdMessage());
		String cookie = CallbackController.getCookie(request);
		Person author = personService.getPersonByCookie(cookie);
		Response response = new Response();
		if(requestBody.getValue().equals("Accept Task")) {
			reportService.getReportNoOpt(x).setState(Report.inlavorazione);
			reportService.getReportNoOpt(x).getTask().setState(Report.inlavorazione);
			author.addTask(reportService.getReportNoOpt(x).getTask());
			reportService.getReportNoOpt(x).getTask().setWorker(author);
			reportService.editReport(reportService.getReportNoOpt(x));
			personService.editPerson(author);
			taskService.editTask(reportService.getReportNoOpt(x).getTask());
			messageService.getMessageNoOpt(z).setRead(true);
			messageService.editMessage(messageService.getMessageNoOpt(z));
			response = new Response("Done", "accettato");
		} else {
			messageService.getMessageNoOpt(z).setRead(true);
			messageService.editMessage(messageService.getMessageNoOpt(z));
			response = new Response("Done", "rifiutato");
		}
		
		return response;
	}
	//a city admin can give the prize(points and experience) of a task to a user;
	@PostMapping(value = "/assignPoints")
	public Response assignPoints(@RequestBody AcceptRefuseTaskRequestBody requestBody,HttpServletRequest request) {
		Long x = Long.valueOf(requestBody.getValue());
		int points = taskService.getTaskNoOpt(x).getPoints();
		int exp = taskService.getTaskNoOpt(x).getExp();
		if (taskService.getTaskNoOpt(x).getWorker() != null) {
			if (taskService.getTaskNoOpt(x).getWorker().expOrPointsInRange(points,exp)) {
		Person worker = taskService.getTaskNoOpt(x).getWorker();
		worker.addPoints(points);
		worker.addExp(exp);
		personService.editPerson(worker);
		return new Response("Done", worker.getName() + " " + worker.getSurname());
			} else {
				return new Response("Fail", "Hai raggiunto il numero massimo di Points o Exp!");
			}
		} else {
			return new Response("Fail","Nessun worker trovato!");
		}
	}
}