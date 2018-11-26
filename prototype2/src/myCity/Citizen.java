package myCity;

import java.time.LocalDate;


public class Citizen {

	private String name;
	private String surname;
	private LocalDate birthday;
	private String email;
	protected static int count = 0;
	protected int citizenID;

	
	public Citizen(String name, String surname, LocalDate birthday, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birthday = birthday;
		setCitizenID(++count);
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


	void sendReport(Report report,Board hisCity) {		
		if(hisCity.isACitizen(this)){
		hisCity.addReport(report);
		}	
	}
	
	void writeComment(Comment comment, Report report){	
		report.addComment(comment);	
	}


	public int getCitizenID() {
		return citizenID;
	}


	public void setCitizenID(int citizenID) {
		this.citizenID = citizenID;
	}
	
	public String toString() {
		return getName()+" "+getSurname();	
	}	
	
}


