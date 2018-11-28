package myCity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Map.Entry;


public class CityAdmin  {
	
	private String name;
	private String surname;
	private LocalDate birthday;
	private String email;
	private static int count = 0;
	private int cityadminID;

	
	
	public CityAdmin(String name, String surname, LocalDate birthday, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birthday = birthday;
		setCityadminID(++count);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static int getCount() {
		return count;
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
		System.out.println("Seleziona la richieste da accettare :");
		for (Entry<Worker, ApplyRequest> element : taskManager.analyzeWorkerRequests(task)) {
			System.out.println(element.getKey().getCitizenID() + ") " +element);
		}
		InputStream workerChoosen = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(workerChoosen));
		int citizenID = Integer.parseInt(br.readLine());
		for (Entry<Worker, ApplyRequest> element : taskManager.analyzeWorkerRequests(task)) {
			if (element.getKey().getCitizenID() == citizenID) {
				System.out.println("il Worker scelto e :" + element.getKey().getName() + " " + element.getKey().getSurname());
				element.getKey().addConfirmRequest(task);
			}
			
		}
	}
}
	