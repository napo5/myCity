package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import app.model.Message;
import app.model.Person;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

	@Query(value="SELECT * FROM MESSAGE m WHERE LOWER(m.id) = LOWER(?1)",nativeQuery = true)
    public Message getMessageNoOpt(@Param("idMessage") Long idMessage);
	
	@Query(value="SELECT * FROM MESSAGE m WHERE LOWER(m.person_id) = LOWER(?1)",nativeQuery = true)
    public List<Message> getMessageByPerson(@Param("person") Person person);
}
