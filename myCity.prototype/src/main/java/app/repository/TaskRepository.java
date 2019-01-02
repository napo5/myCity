package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.model.Report;
import app.model.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {
	
	@Query(value = "SELECT * FROM REPORT r ", nativeQuery=true)
    public List<Report> getAllReport();
}
