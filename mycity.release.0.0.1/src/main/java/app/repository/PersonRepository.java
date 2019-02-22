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
	
	@Query(value="SELECT * FROM PERSON p WHERE LOWER(p.cookie) = LOWER(?1)",nativeQuery = true)
    public Person findByCookie(@Param("cookie") String cookie);
	
	@Query(value="SELECT * FROM PERSON p WHERE LOWER(p.email) = LOWER(?1)",nativeQuery = true)
    public Person findByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM PERSON p WHERE LOWER(p.id) = LOWER(?1)", nativeQuery=true)
    public Person getPersonNoOpt(@Param("id")Long id);

}