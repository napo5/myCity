package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Candidature;
import app.model.Person;
import app.model.Task;
import app.repository.CandidatureRepository;

@Service
public class CandidatureServiceImpl implements CandidatureService {

	@Autowired
	private CandidatureRepository candidatureRepository;
	
	@Override
	public Candidature createCandidature(Candidature candidature) {
		return candidatureRepository.save(candidature);
	}

	@Override
	public Optional<Candidature> getCandidature(Long id) {
		return candidatureRepository.findById(id);
	}

	@Override
	public Candidature editCandidature(Candidature candidature) {
		return candidatureRepository.save(candidature);
	}

	@Override
	public void deleteCandidature(Candidature candidature) {
		candidatureRepository.delete(candidature);
	}

	@Override
	public void deleteCandidature(Long id) {
		candidatureRepository.deleteById(id);
	}

	@Override
	public List<Candidature> getAllCandidatures() {
		return candidatureRepository.findAll();
	}

	@Override
	public List<Candidature> findAllByTask(Task task) {
		return candidatureRepository.findAllByTask(task);
	}

	@Override
	public List<Candidature> findAllByPerson(Person person) {
		return candidatureRepository.findAllByPerson(person);
	}
	
	@Override
	public Candidature findUnique(Person person, Task task) {
		return candidatureRepository.findUnique(person,task);
	}
	
}
