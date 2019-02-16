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
import app.service.CommentService;
import app.service.MessageService;
import app.service.PersonService;
import app.service.ReportService;

@Controller
public class PersonController {
	private final PersonService personService;
	private final ReportService reportService;
	private final CommentService commentService;
	private final MessageService messageService;

	@Autowired
	public PersonController(PersonService personService, ReportService reportService, CommentService commentService, MessageService messageService) {
		this.personService = personService;
		this.reportService = reportService;
		this.commentService = commentService;
		this.messageService = messageService;
	}

	//home method;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage(Model model) {
		return "redirect:/reportList";
	}
	
	//get all the people registered;
	@RequestMapping(value = "/peopleList", method = RequestMethod.GET)
	public String peopleList(Model model, HttpServletRequest request) {
			model.addAttribute("persons", personService.getAllPersons());
			String cookie = CallbackController.getCookie(request);
			model.addAttribute("currentPerson", personService.getPersonByCookie(cookie));
			String referer = request.getHeader("Referer");
			model.addAttribute("refer",referer);
			return "allPeople";
		}
	
	//set a user as cityadmin role;
	@RequestMapping(value = "/setCityAdmin/{personId}", method = RequestMethod.GET)
	public String setCityAdmin(@PathVariable(value="personId") String personId,Model model, HttpServletRequest request) {
			model.addAttribute("persons", personService.getAllPersons());
			String referer = request.getHeader("Referer");
			model.addAttribute("refer",referer);
			Long x = Long.valueOf(personId);
			personService.getPersonNoOpt(x).setRole(Person.cityadmin);
			personService.editPerson(personService.getPersonNoOpt(x));
			String cookie = CallbackController.getCookie(request);
			Person author = personService.getPersonByCookie(cookie);
			model.addAttribute("currentPerson",author);
			return "allPeople";
		}
	//get all reports and comments of a person;
	@RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
	public String getAllReport(@PathVariable(value="personId")String personId, Model model, HttpServletRequest request) {
		Long x = Long.valueOf(personId);
		if(personService.getPersonNoOpt(x) != null) {
		model.addAttribute("reports",reportService.getByName(personService.getPersonNoOpt(x)));
		model.addAttribute("refer",request.getHeader("Referer"));
		model.addAttribute("comments", commentService.getAllComments());
		String cookie = CallbackController.getCookie(request);
		Person person= personService.getPersonByCookie(cookie);
		model.addAttribute("role", person.getRole());
		return "allReports";
		} else return "Errore!";
	}
	
	//get the person who called this method;
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model, HttpServletRequest request) {
		String cookie = CallbackController.getCookie(request);
		Person author = personService.getPersonByCookie(cookie);
		return "redirect:/profile/" + author.getEmail();
		}
	//get the person and all his informations;
	@RequestMapping(value = "/profile/{personEmail}", method = RequestMethod.GET)
	public String seeProfileTrue(@PathVariable(value="personEmail")String personEmail,Model model, HttpServletRequest request) {
		model.addAttribute("person",personService.getPersonByEmail(personEmail));
		model.addAttribute("refer", request.getHeader("Referer"));
		return "profile";
		}
	
	@RequestMapping(value ="/offline", method = RequestMethod.GET)
	public String offline() {
		return "offline";
	}
	
	//reset the cookie when a user logout;
	@RequestMapping(value = "/manageLogout", method = RequestMethod.GET)
    public String logout(final HttpServletRequest req) {
	    	String cookie = CallbackController.getCookie(req);
			Person author = personService.getPersonByCookie(cookie);
			author.setCookie("");
	        return "redirect:/logout";
	    }
	//works when a user login for the 1st time;
	@RequestMapping(value = "/firstLogin", method = RequestMethod.GET)
	public String firstLogin(Model model) {
		model.addAttribute("person", new Person());
		return "registrationPage";
	}
	
	//create the person and add his information, only the first time;
	@RequestMapping(value = "/afterFirstLogin", method = RequestMethod.POST)
	public String afterFirstLogin(Model model,@ModelAttribute Person person,final HttpServletRequest req) {
		String cookie = CallbackController.getCookie(req);
		Person author = personService.getPersonByCookie(cookie);
		author.setName(person.getName());
		author.setSurname(person.getSurname());
		author.setCity(person.getCity());
		author.setRole(person.getRole());
		personService.createPerson(author);
		return "redirect:/reportList";
	}
	//get all messages of a user;
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public String getMessages(Model model, HttpServletRequest request) {
		String cookie = CallbackController.getCookie(request);
		if(personService.getPersonByCookie(cookie) != null){
		model.addAttribute("messages",messageService.getMessageByPerson(personService.getPersonByCookie(cookie)));
		String referer = request.getHeader("Referer");
		model.addAttribute("refer",referer);
		return "messages";
		} else return "Error! User not found by cookie!";
	}
	//check if a user is a city admin;
	@RequestMapping(value = "/isAdmin", method = RequestMethod.GET)
	public boolean isAdmin(Model model, HttpServletRequest request) {
		String cookie = CallbackController.getCookie(request);
		Person author = personService.getPersonByCookie(cookie);
		return author.getRole().equals(Person.cityadmin) ? true : false;
	}
	
}