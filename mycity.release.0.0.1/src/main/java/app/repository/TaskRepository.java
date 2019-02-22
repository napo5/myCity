package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {
	
	@Query(value = "SELECT * FROM TASK t WHERE LOWER(t.report_id) = LOWER(?1)", nativeQuery=true)
    public Task getTaskByReportId(@Param("idReport") Long idReport);
	
	@Query(value = "SELECT * FROM TASK t WHERE LOWER(t.worker_id) = LOWER(?1)", nativeQuery=true)
    public List<Task> getTaskByWorkerId(@Param("idWorker") Long idWorker);
	
	@Query(value = "SELECT * FROM TASK t WHERE LOWER(t.id) = LOWER(?1)", nativeQuery=true)
    public Task getTaskNoOpt(@Param("id")Long id);
}
