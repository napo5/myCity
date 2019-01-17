package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.model.Person;
import app.model.Report;
import app.service.PersonService;
import app.service.ReportService;

@Controller
public class ReportController {
	private final ReportService reportService;
	private final PersonService personService;

	@Autowired
	public ReportController(ReportService reportService, PersonService personService) {
		this.reportService = reportService;
		this.personService = personService;
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
		return "reportResult";
	}
	@RequestMapping(value = "/reportList")
	public String reportList(Model model,HttpServletRequest request) {
		model.addAttribute("reports", reportService.getAllReport());
		String referer = request.getHeader("Referer");
		model.addAttribute("refer",referer);
		return "reportResult";
		}
	
}
