package app.service;
import java.util.List;
import java.util.Optional;
import app.model.Person;
import app.model.Report;


public interface ReportService {
	Report createReport(Report report);

	Optional<Report> getReport(Long id);
	
	Report getReportNoOpt(Long id);

	Report editReport(Report report);

	void deleteReport(Report report);

	void deleteReport(Long id);

	List<Report> getAllReports();
	
	List<Report> getAllReport();
	
	List<Report> getByName(Person name);
}