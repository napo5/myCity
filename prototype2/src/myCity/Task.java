package myCity;

import java.util.HashMap;
import java.util.Scanner;


public class Task {
	
	private static int count = 0;
	private int taskID;
	private String description;
	private int points;
	private int exp;
	private TaskState state;
	private Worker personInCharge; // the worker who has been choose to solve the task;
	private HashMap<Worker,ApplyRequest> applyList = new HashMap<Worker,ApplyRequest>();
	private int positiveCheck = 0;
	private int negativeCheck = 0;
	private int neededChecks;
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

		this.state = TaskState.WAITING_FOR_WORKER;
		
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

	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}


	public void printApplyList() {
		for (HashMap.Entry<Worker, ApplyRequest> entry : applyList.entrySet()) {
		    System.out.println(entry.getKey().getName()+" "+ entry.getKey().getSurname() +" : "+entry.getValue().getDaysToComplete());
		}
	}

	public void addApply(Worker applicant,ApplyRequest request) {
		this.applyList.put(applicant, request);
	}

	public void addCitizenCheck(Citizen citizen, boolean confirm) {
		if(confirm==true){
			positiveCheck++;
		}
		if(confirm==false){
			negativeCheck++;
		}

		// example exp and points
		citizen.setExp(citizen.getExp()+5);
		citizen.setPoints(citizen.getPoints()+1);

		if(positiveCheck == neededChecks){
			//assign points to worker and change state
		}

		if(negativeCheck == neededChecks){
			//search other worker
		}

	}

	

}
