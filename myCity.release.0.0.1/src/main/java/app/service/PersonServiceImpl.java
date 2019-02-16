package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Person;
import app.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Optional<Person> getPerson(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public Person editPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(Person person) {
		personRepository.delete(person);
	}

	@Override
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}


	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person getPerson(String name) {
		return personRepository.findByName(name);
	}
	
	@Override
	public Person getPersonByCookie(String cookie) {
		return personRepository.findByCookie(cookie);
	}
	
	@Override
	public Person getPersonByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	@Override
	public Person getPersonNoOpt(Long id) {
		return personRepository.getPersonNoOpt(id);
	}
	
}
