package myCity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Worker extends Citizen {

	private ArrayList<Task> confirmRequest = new ArrayList<Task>();

	public Worker(String name, String surname, LocalDate birthday, String email) {
		super(name, surname, birthday, email);
	}
	
	public void applyForTask(Report report,int daysToComplete) {
		ApplyRequest applyRequest = new ApplyRequest(daysToComplete);
		report.getTask().addApply(this, applyRequest);
	}
	
	public void addConfirmRequest(Task task){
		this.confirmRequest.add(task);
	}
	
	public ArrayList<Task> getConfirmRequest() {
		return this.confirmRequest;
	}
	
	public void printConfirmRequest() {
		    if (this.confirmRequest.size()== 0) {
		    	System.out.println("Non hai ricevuto nessuna conferma per un task");
		    	return;
		    } else {
		    System.out.println("Sei stato scelto per questi task:");
			for (Task task : this.confirmRequest) {
			System.out.println(task.getTaskID() + ") " + task.getDescription());
			System.out.println("riceverai: " + task.getPoints() + " punti e " + task.getExp() + " esperienza!");
			}
	    }
	}
	
	public void acceptTask() throws NumberFormatException, IOException {
		printConfirmRequest();
		InputStream taskChoosen = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(taskChoosen));
		int taskID = Integer.parseInt(br.readLine());
		for (Task task : this.confirmRequest) {
			System.out.println(task.getTaskID());
			if (task.getTaskID() == taskID && task.getPersonInCharge() == null)
				task.setPersonInCharge(this);
		}
	}
	
	public void refuseTask() throws NumberFormatException, IOException {  //the cityAdmin should be notified.
		printConfirmRequest();
		InputStream taskChoosen = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(taskChoosen));
		int taskID = Integer.parseInt(br.readLine());
		Iterator<Task> iterator = confirmRequest.iterator();
		while (iterator.hasNext()) {
			Task taskSelected = iterator.next();
			if (taskSelected.getTaskID() == taskID) {
				taskSelected.getApplyList().remove(this);
				iterator.remove();
			}
		}
	}
	
	
}
