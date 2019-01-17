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
import app.service.PersonService;
import app.service.ReportService;

@Controller
public class PersonController {
	private final PersonService personService;
	private final ReportService reportService;

	@Autowired
	public PersonController(PersonService personService, ReportService reportService) {
		this.personService = personService;
		this.reportService = reportService;
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
		return "reportResult";
		} else return "Errore!";
	}
}