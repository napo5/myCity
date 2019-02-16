package app.service;

import java.util.List;
import java.util.Optional;

import app.model.Candidature;
import app.model.Person;
import app.model.Task;

public interface CandidatureService {
	Candidature createCandidature(Candidature candidature);

	Optional<Candidature> getCandidature(Long id);
	
	Candidature editCandidature(Candidature candidature);

	void deleteCandidature(Candidature candidature);

	void deleteCandidature(Long id);

	List<Candidature> getAllCandidatures();
	
	List<Candidature> findAllByTask(Task task);
	
	List<Candidature> findAllByPerson(Person person);
	
	Candidature findUnique(Person person, Task task);
}
