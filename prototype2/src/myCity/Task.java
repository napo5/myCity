package myCity;

import java.util.HashMap;
import java.util.Scanner;


public class Task {
	
	private static int count = 0;
	private int taskID;
	private String description;
	private int points;
	private int exp;
	private Worker personInCharge; // the worker who has been choose to solve the task;
	private HashMap<Worker,ApplyRequest> applyList = new HashMap<Worker,ApplyRequest>();

	public Task(String description, int points, int exp) {
		this.description = description;
		this.points = points;
		this.exp = exp;
		setTaskID(++count);
	}
	
	/* let city admin create task from console */
	public Task() {
		
		System.out.println("Insert description of the task : ");
		Scanner inputDescription = new Scanner(System.in);
		this.description = inputDescription.nextLine();
		 
		System.out.println("Insert points of the task : ");
		Scanner inputPoints = new Scanner(System.in);
		this.points = inputPoints.nextInt();
		
		System.out.println("Insert exp of the task : ");
		Scanner inputExp = new Scanner(System.in);
		this.points = inputPoints.nextInt();
		
	}
	
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	
	public int getTaskID() {
		return this.taskID;
	}
	
	public HashMap<Worker,ApplyRequest> getApplyList() {  
		return this.applyList;
	}
	
	public void setPersonInCharge(Worker personInCharge) {
		this.personInCharge = personInCharge;
	}
	
	public Worker getPersonInCharge() {
		return this.personInCharge;
	}
	
	public void printApplyList() {
		for (HashMap.Entry<Worker, ApplyRequest> entry : applyList.entrySet()) {
		    System.out.println(entry.getKey().getName()+" "+ entry.getKey().getSurname() +" : "+entry.getValue().getDaysToComplete());
		}
	}

	public void addApply(Worker applicant,ApplyRequest request) {
		this.applyList.put(applicant, request);
	}

	

}
