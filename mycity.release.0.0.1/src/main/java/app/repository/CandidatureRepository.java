package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Candidature;
import app.model.Person;
import app.model.Task;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long>{

	@Query(value="SELECT * FROM CANDIDATURE c WHERE LOWER(c.task_id) = LOWER(?1)",nativeQuery = true)
    public List<Candidature> findAllByTask(@Param("task") Task task);
	
	@Query(value="SELECT * FROM CANDIDATURE c WHERE LOWER(c.person_id) = LOWER(?1)",nativeQuery = true)
    public List<Candidature> findAllByPerson(@Param("person") Person person);
	
	@Query(value="SELECT * FROM CANDIDATURE c WHERE LOWER(c.person_id) = LOWER(?1) AND LOWER(c.task_id) = LOWER(?2)",nativeQuery = true)
    public Candidature findUnique(@Param("person") Person person,@Param("task") Task task);
}
