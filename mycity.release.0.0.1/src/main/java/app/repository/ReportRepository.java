package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Person;
import app.model.Report;

@Repository
public interface ReportRepository  extends JpaRepository<Report, Long> {
	
	@Query(value = "SELECT * FROM REPORT r WHERE LOWER(r.person_id) = LOWER(?1)", nativeQuery=true)
    public List<Report> findByName(@Param("name") Person name);
	
	@Query(value = "SELECT * FROM REPORT r ", nativeQuery=true)
    public List<Report> getAllReport();
	
	@Query(value = "SELECT * FROM REPORT r WHERE LOWER(r.id) = LOWER(?1)", nativeQuery=true)
    public Report getReportNoOpt(@Param("id")Long id);
}
