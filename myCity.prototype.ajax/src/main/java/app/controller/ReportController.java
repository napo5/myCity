package app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.model.Comment;
import app.model.Person;
import app.model.Report;
import app.service.CommentService;
import app.service.PersonService;
import app.service.ReportService;

@Controller
public class ReportController {
	private final ReportService reportService;
	private final PersonService personService;
	private final CommentService commentService;
	
	@Autowired
	public ReportController(ReportService reportService, PersonService personService, CommentService commentService) {
		this.reportService = reportService;
		this.personService = personService;
		this.commentService = commentService;
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("report", new Report());
		model.addAttribute("author", new Person());
		return "report";
	}

	@RequestMapping(value = "/reportAdd")
	public String addPagePerson(@ModelAttribute Report report,@ModelAttribute Person author, Model model,HttpServletRequest request) {
		if (personService.getPerson(author.getName()) == null) {
		personService.createPerson(author);
		report.setAuthor(author);
		} else report.setAuthor(personService.getPerson(author.getName()));
		reportService.createReport(report);
		model.addAttribute("reports", reportService.getAllReport());
		String referer = request.getHeader("Referer");
		model.addAttribute("refer",referer);
		model.addAttribute("comments", commentService.getAllComments());
		return "reportResult";
	}
	@RequestMapping(value = "/reportList")
	public String reportList(Model model,HttpServletRequest request) {
		model.addAttribute("reports", reportService.getAllReport());
		//Comment comment = new Comment("titolo comment","descrizione commento");
		//commentService.createComment(comment);
		//model.addAttribute("comments", commentService.getAllComments());
		//devo caricare i commenti
		String referer = request.getHeader("Referer");
		model.addAttribute("refer",referer);
		return "reportResult";
		}
	
	@RequestMapping(value = "/addComment/{idReport}" , method = RequestMethod.GET)
	public String addComment(@PathVariable("idReport") String idReport,Model model,HttpServletRequest request,@RequestParam("comment")String prova) {
		Long x = Long.valueOf(idReport);
		Comment comment = new Comment(prova);
		Report target = reportService.getReport(x).get();
		comment.setReport(target);
		commentService.createComment(comment);
		target.addComment(comment);
		reportService.createReport(target);
		model.addAttribute("reports", reportService.getAllReport());
		model.addAttribute("comments", commentService.getAllComments());
		return "redirect:/seeReport/"+target.getId();	
	}
	
	@RequestMapping(value = "/seeReport/{idReport}" ,method = RequestMethod.GET)
	public String seeReport(@PathVariable("idReport")String idReport,Model model) {
		Long x = Long.valueOf(idReport);
		Report report = reportService.getReport(x).get();
		report.addViews();
		reportService.createReport(report);
		model.addAttribute("report", report);
		model.addAttribute("comments", commentService.findByReport(reportService.getReport(x).get()));
		return "seeReport";
	}
	
}
