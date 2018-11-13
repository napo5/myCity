package myCity;

import java.time.LocalDate;


public class CityAdmin extends User {
	
	private static int count = 0;
	private int cityadminID;
	
	
	public CityAdmin(String name, String surname, LocalDate birthday, String email) {
		super(name, surname, birthday, email);
		setCityadminID(++count);
	}
	
	void changeState(Report report, ReportState state) {	
		report.setState(state);
		if(state==ReportState.TASK_AVAILABLE) {
			Task newtask = new Task();
			report.setTask(newtask);
			}		
	}
	
	
	void createTask(Task task, Report report) {	
		report.setTask(task);
		report.setState(ReportState.TASK_AVAILABLE);
	}


	public int getCityadminID() {
		return cityadminID;
	}


	public void setCityadminID(int cityadminID) {
		this.cityadminID = cityadminID;
	}
	
}
	