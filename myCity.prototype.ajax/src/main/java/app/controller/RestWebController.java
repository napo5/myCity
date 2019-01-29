package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.AddCommentRequestBody;
import app.model.Comment;
import app.model.Person;
import app.model.Report;
import app.model.Response;
import app.model.createReportRequestBody;
import app.service.CommentService;
import app.service.PersonService;
import app.service.ReportService;


@RestController
@RequestMapping("/api/customer")
public class RestWebController {

	List<AddCommentRequestBody> protoList = new ArrayList<AddCommentRequestBody>();
	private final ReportService reportService;
	private final CommentService commentService;
	private final PersonService personService;

	@Autowired
	public RestWebController(ReportService reportService, CommentService commentService, PersonService personService) {
		this.reportService = reportService;
		this.commentService = commentService;
		this.personService = personService;
	}
		

	@PostMapping(value = "/save/{idReport}")
	public Response postCustomer(@RequestBody AddCommentRequestBody requestBody,@PathVariable("idReport") String idReport) {
		protoList.add(requestBody);
		
		Long x = Long.valueOf(idReport);
		Comment comment = new Comment(requestBody.getDescription());
		Report target = reportService.getReport(x).get();
		comment.setReport(target);
		commentService.createComment(comment);
		target.addComment(comment);
		reportService.createReport(target);
		
		Response response = new Response("Done", protoList);
		return response;
	}
	
	@PostMapping(value = "/createReport")
	public Response createReport(@RequestBody createReportRequestBody requestBody) {
		Person person = new Person();
		person.setName(requestBody.getName());
		personService.createPerson(person);
		Report report = new Report();
		report.setDescription(requestBody.getDescription());
		report.setTitle(requestBody.getTitle());
		report.setImage(requestBody.getImage());
		report.setAuthor(person);
		reportService.createReport(report);
		Response response = new Response("Done", requestBody);
		return response;
	}
	
	@GetMapping(value = "/loadComment")
	public Response loadComment() {
		Response response = new Response("Done",protoList);
		return response;
	}
	
	
}