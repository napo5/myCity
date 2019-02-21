package app.controller;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import app.model.Candidature;

import app.model.Person;
import app.model.Report;
import app.service.CandidatureService;
import app.service.CommentService;
import app.service.PersonService;
import app.service.ReportService;

@Controller
public class ReportController {
	private final ReportService reportService;
	private final PersonService personService;
	private final CommentService commentService;
	private final CandidatureService candidatureService;
	 
	
	@Autowired
	public ReportController(ReportService reportService, PersonService personService, CommentService commentService, CandidatureService candidatureService) {
		this.reportService = reportService;
		this.personService = personService;
		this.commentService = commentService;
		this.candidatureService = candidatureService;
	}
	//prepare to create a new report;
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("report", new Report());
		return "newReport";
	}
	
	//get the list of all the reports;
	@RequestMapping(value = "/reportList", method = RequestMethod.GET)
	public String reportList(Model model,HttpServletRequest request) {
		model.addAttribute("reports", reportService.getAllReport());
		String referer = request.getHeader("Referer");
		String cookie = CallbackController.getCookie(request);
		Person person= personService.getPersonByCookie(cookie);
		model.addAttribute("role", person.getRole());
		model.addAttribute("refer",referer);
		return "allReports";
		}
	//get a specify report from his id;
	@RequestMapping(value = "/seeReport/{idReport}" ,method = RequestMethod.GET)
	public String seeReport(@PathVariable("idReport")String idReport,Model model,HttpServletRequest request) {
		Long x = Long.valueOf(idReport);
		Report report = reportService.getReport(x).get();
		model.addAttribute("report", report);
		model.addAttribute("comments", commentService.findByReport(reportService.getReport(x).get()));
		String cookie = CallbackController.getCookie(request);
		Person person = personService.getPersonByCookie(cookie);
		model.addAttribute("role", person.getRole());
		if (report.getTask() != null &&  report.getTask().getWorker() == person) {model.addAttribute("isWorkerInCharge", true);
		} else {
			model.addAttribute("isWorkerInCharge", false);
		}
		return "seeReport";
	}
	//get all candidatures for a particular report;
	@RequestMapping(value = "/chooseWorker/{idReport}", method= RequestMethod.GET)
	public String chooseWorker(Model model, HttpServletRequest request,@PathVariable("idReport") String idReport) {
		Long x = Long.valueOf(idReport);
		String referer = request.getHeader("Referer");
		List<Candidature> listOfApply = candidatureService.findAllByTask(reportService.getReportNoOpt(x).getTask());
		List<Person> listOfPeople = new ArrayList<Person>();
		for (Candidature can : listOfApply) {
			listOfPeople.add(can.getPeople());
		}
		model.addAttribute("idReport", x);
		model.addAttribute("person", listOfPeople);
		model.addAttribute("refer",referer);
		return "chooseWorker";
	}
	
	//close a task, setting it as closed (some features are still missing)
	@RequestMapping(value = "/closeTask/{idReport}", method= RequestMethod.GET)
	public String closeTask(Model model, HttpServletRequest request,@PathVariable("idReport") String idReport) {
		Long x = Long.valueOf(idReport);
		reportService.getReportNoOpt(x).getTask().setState(Report.chiuso);
		reportService.getReportNoOpt(x).setState(Report.chiuso);
		reportService.editReport(reportService.getReportNoOpt(x));
		return "redirect:/seeReport/" + idReport;
	}
	
}
