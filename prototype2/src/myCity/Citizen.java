package myCity;

import java.time.LocalDate;


public class Citizen extends User {

	private static int count = 0;
	private int citizenID;

	
	public Citizen(String name, String surname, LocalDate birthday, String email) {
		super(name, surname, birthday, email);
		setCitizenID(++count);
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


