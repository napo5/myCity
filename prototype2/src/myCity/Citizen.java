package myCity;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;


public class Citizen {

	private String name;
	private String surname;
	private LocalDate birthday;
	private String email;
	private int points;
	private int exp;
	protected static AtomicInteger count = new AtomicInteger(0);
	protected int citizenID;



	
	public Citizen(String name, String surname, LocalDate birthday, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birthday = birthday;
		this.citizenID = count.incrementAndGet();
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

	void sendReport(Report report,Board hisCity) {
		if(hisCity.isACitizen(this)){
		hisCity.addReport(report);
		}	
	}

	public int getCitizenID() {
		return citizenID;
	}

	public void setCitizenID(int citizenID) {
		this.citizenID = citizenID;
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
	
	public void checkTaskDone(Task task, TaskDone confirm){
		//TaskDone should be created now.
		if (task.getState()==TaskState.WAITING_FOR_CONFIRMS){
				task.addCitizenCheck(this,confirm);
		}
	}

	void writeComment(Comment comment, Report report){
		report.addComment(comment);
	}
	
	public String toString() {
		return getName()+" "+getSurname();	
	}	
	
}


