package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.Comment;
import app.model.Proto;
import app.model.Report;
import app.model.Response;
import app.service.CommentService;
import app.service.PersonService;
import app.service.ReportService;


@RestController
@RequestMapping("/api/customer")
public class RestWebController {

	List<Proto> protoList = new ArrayList<Proto>();
	private final ReportService reportService;
	private final CommentService commentService;

	@Autowired
	public RestWebController(ReportService reportService, CommentService commentService) {
		this.reportService = reportService;
		this.commentService = commentService;
	}
		

	@PostMapping(value = "/save/{idReport}")
	public Response postCustomer(@RequestBody Proto proto,@PathVariable("idReport") String idReport) {
		protoList.add(proto);
		
		Long x = Long.valueOf(idReport);
		Comment comment = new Comment(proto.getDescription());
		Report target = reportService.getReport(x).get();
		comment.setReport(target);
		commentService.createComment(comment);
		target.addComment(comment);
		reportService.createReport(target);
		
		Response response = new Response("Done", proto);
		return response;
	}
}