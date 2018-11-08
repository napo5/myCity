package myCity;

import java.util.Vector;

public class Board {
	
	
	 private String city;
	 
	 
	Vector<Report> reports = new Vector<Report>(); 
	Vector<Citizen> citizens = new Vector<Citizen>();
	Vector<CityAdmin> admins = new Vector<CityAdmin>();

	Board() {
		 
	
	
}	
	
	
	void addReport(Report report) {
		reports.addElement(report);
	}
	
	void addCitizen(Citizen citizen) {
		citizens.addElement(citizen);
	}
	
	void addAdmin(CityAdmin admin) {
		admins.addElement(admin);
	}
	
	
	boolean isACitizen(Citizen citizenToCheck) {
		if(this.citizens.contains(citizenToCheck)){
			return true;
		}
		else return false;
	}
	
	void printReports() {
		for( int i =0; i < reports.size();i++) {
			System.out.println(reports.get(i).toString());
		}
	}
	


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Vector<Report> getReports() {
		return reports;
	}


	public void setReports(Vector<Report> reports) {
		this.reports = reports;
	}


	 
}

