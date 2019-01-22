package app.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.model.Person;
import app.service.CommentService;
import app.service.PersonService;
import app.service.ReportService;

@Controller
public class PersonController {
	private final PersonService personService;
	private final ReportService reportService;
	private final CommentService commentService;

	@Autowired
	public PersonController(PersonService personService, ReportService reportService, CommentService commentService) {
		this.personService = personService;
		this.reportService = reportService;
		this.commentService = commentService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("person", new Person());
		return "greeting";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String addPagePerson(@ModelAttribute Person person, Model model) {
		if(personService.getPerson(person.getName()) == null) {
			personService.createPerson(person);
		}
		model.addAttribute("persons", personService.getAllPersons());
		return "result";
	}
	
	@RequestMapping(value = "/peopleList", method = RequestMethod.GET)
	public String peopleList(Model model, HttpServletRequest request) {
			model.addAttribute("persons", personService.getAllPersons());
			String referer = request.getHeader("Referer");
			model.addAttribute("refer",referer);
			return "result";
		}
	
	
	@RequestMapping(value = "/person/{name}", method = RequestMethod.GET)
	public String getAllReport(@PathVariable(value="name")String name, Model model, HttpServletRequest request) {
		if(personService.getPerson(name) != null){
		model.addAttribute("reports",reportService.getByName(personService.getPerson(name)));
		String referer = request.getHeader("Referer");
		model.addAttribute("refer",referer);
		model.addAttribute("comments", commentService.getAllComments());
		return "reportResult";
		} else return "Errore!";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model, HttpServletRequest request) {
			model.addAttribute("personId",new String());
			return "askPerson";
		}
	
	@RequestMapping(value = "/profile/{personName}", method = RequestMethod.GET)
	public String seeProfileTrue(@PathVariable(value="personName")String personName,Model model, HttpServletRequest request) {
		model.addAttribute("person",personService.getPerson(personName));
		return "profile";
		}
	
}