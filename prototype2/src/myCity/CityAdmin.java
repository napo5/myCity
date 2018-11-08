package myCity;

import java.util.Date;

public class CityAdmin extends User {

	public CityAdmin(int iD, String name, String surname, String city, Date birthday, String email) {
		super(iD, name, surname, city, birthday, email);
		// TODO Auto-generated constructor stub
	}
	
	
	void changeState(Report report, ReportState state) {
		
		report.setState(state);
		
		
	}

	

}
	