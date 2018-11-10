package myCity;

import java.util.Date;

public class Citizen extends User {

	

	public Citizen(int iD, String name, String surname, String city, Date birthday, String email) {
		super(name, surname, city, birthday, email);
		// TODO Auto-generated constructor stub
	}

	
	void sendReport(Report report,Board hisCity) {
			
		if(hisCity.isACitizen(this)){
		hisCity.addReport(report);
		}
		
	}
	
	void writeComment(Comment comment, Report report){
		
		report.addComment(comment);
		
	}
	
	
	
	
	
	
}


