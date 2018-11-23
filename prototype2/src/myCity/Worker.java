package myCity;

import java.time.LocalDate;

public class Worker extends Citizen {

	
	public Worker(String name, String surname, LocalDate birthday, String email) {
		super(name, surname, birthday, email);
	}
	
	public void applyForTask(Report report,int daysToComplete) {
		ApplyRequest applyRequest = new ApplyRequest(daysToComplete);
		report.getTask().addApply(this, applyRequest);
	}
}
