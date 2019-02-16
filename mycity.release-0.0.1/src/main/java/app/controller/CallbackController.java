package app.controller;


import app.model.Person;
import app.security.TokenAuthentication;
import app.security.TokenDecoder;
import app.service.PersonService;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@CrossOrigin(origins = "http://localhost:8080")
@SuppressWarnings("unused")
@Controller
public class CallbackController {

    @Autowired
    private AuthenticationController controller;
    private final String redirectOnFail;
    private final String redirectOnSuccess;
    private final String redirectOnSuccessFirstTime;
    public static String nomeUtente;
    private final PersonService personService;

    public CallbackController(PersonService personService) {
        this.redirectOnFail = "/login";
        this.redirectOnSuccess = "/reportList";
        this.redirectOnSuccessFirstTime = "/firstLogin";
        this.personService = personService;
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    protected void getCallback(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        handle(req, res);
    }

    @RequestMapping(value = "/callback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    protected void postCallback(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        handle(req, res);
    }

    public void handle(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            Tokens tokens = controller.handle(req);
            TokenAuthentication tokenAuth = new TokenAuthentication(JWT.decode(tokens.getIdToken()));
//just for testing;
            if(personService.getPersonByEmail("diego@studiograficod2.it") == null) {
            Person diego = new Person();
            Person mirko = new Person();
            mirko.setEmail("mirko.calvaresi@unicam.it");
            diego.setEmail("diego@studiograficod2.it");
            mirko.setName("Mirko");
            diego.setName("Diego");
            mirko.setSurname("Calvaresi");
            diego.setSurname("Bonura");
            mirko.setRole(Person.cityadmin);
            diego.setRole(Person.cityadmin);
            personService.createPerson(diego);
            }
//          check with email if user already exist;
            if (personService.getPersonByEmail(TokenDecoder.getEmail(tokenAuth)) == null){
            	Person person = new Person();
                person.setEmail(TokenDecoder.getEmail(tokenAuth));
                person.setName(TokenDecoder.getUsername(tokenAuth));
                person.setCookie(getCookie(req));
                personService.createPerson(person); 
                SecurityContextHolder.getContext().setAuthentication(tokenAuth);
                res.sendRedirect(redirectOnSuccessFirstTime);
                return;
            } else {
            	Person person = personService.getPersonByEmail(TokenDecoder.getEmail(tokenAuth));
            	person.setCookie(getCookie(req));
            	personService.createPerson(person); 
            }
            SecurityContextHolder.getContext().setAuthentication(tokenAuth);
            res.sendRedirect(redirectOnSuccess);
        } catch (AuthenticationException | IdentityVerificationException e) {
            e.printStackTrace();
            SecurityContextHolder.clearContext();
            res.sendRedirect(redirectOnFail);
        }
    }
 
    //get the jsessionid cookie;
    public static String getCookie(HttpServletRequest request) {
    	Cookie[] cookie = request.getCookies();
		for (Cookie target : cookie) {
			if ("JSESSIONID".equals(target.getName())) return target.getValue().toString(); 
		}
		return "JSESSIONID not found!";
    }
}
