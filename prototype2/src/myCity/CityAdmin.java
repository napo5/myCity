package myCity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map.Entry;


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
	
	public void chooseWorkerForTask(Task task,TaskManager taskManager) throws IOException { //generate the sorted list of applyRequest of a specific task, and choose the right worker;
		int i = 0;
		System.out.println("Seleziona la richieste da accettare :");
		for (Entry<Worker, ApplyRequest> element : taskManager.analyzeWorkerRequests(task)) {
			System.out.println(i++ + ") " +element);
		}
		InputStream workerChoosen = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(workerChoosen));
		System.out.println("il Worker scelto è :" + br.readLine()); //this will be sostitued with (send confirm request);
	}
}
	