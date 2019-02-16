package app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Person;
import app.model.Report;
import app.repository.ReportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportRepository reportRepository;

	@Override
	public Report createReport(Report report) {
		return reportRepository.save(report);
	}

	@Override
	public Optional<Report> getReport(Long id) {
		return reportRepository.findById(id);
	}

	@Override
	public Report editReport(Report report) {
		return reportRepository.save(report);
	}

	@Override
	public void deleteReport(Report report) {
		reportRepository.delete(report);
		
	}

	@Override
	public void deleteReport(Long id) {
		reportRepository.deleteById(id);
		
	}


	@Override
	public List<Report> getAllReports() {
		return reportRepository.findAll();
	}
	
	@Override
	public List<Report> getByName(Person name){
		return reportRepository.findByName(name);
	}

	@Override
	public List<Report> getAllReport() {
		return reportRepository.getAllReport();
	}

	@Override
	public Report getReportNoOpt(Long id) {
		return reportRepository.getReportNoOpt(id);
	}

	
}
