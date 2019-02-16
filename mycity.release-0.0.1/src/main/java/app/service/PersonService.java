package app.service;

import java.util.List;
import java.util.Optional;

import app.model.Person;

public interface PersonService {
	Person createPerson(Person person);

	Optional<Person> getPerson(Long id);

	Person getPerson(String name);
	
	Person editPerson(Person person);

	void deletePerson(Person person);

	void deletePerson(Long id);

	List<Person> getAllPersons();
	
	Person getPersonByCookie(String cookie);
	
	Person getPersonByEmail(String email);
	
	Person getPersonNoOpt(Long id);
}
