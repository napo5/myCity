package app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query(value="SELECT DISTINCT * FROM PERSON p WHERE LOWER(p.name) = LOWER(?1)",nativeQuery = true)
    public Person findByName(@Param("name") String name);
}