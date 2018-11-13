package myCity;

import java.util.ArrayList;

/**
 * Board
 *
 * Every board belongs to a single city
 * Has its own ID and contains reports about the city,
 * citizens and city admins lists.
 *
 */
public class Board {


	private static int count = 0;
	private int boardID;
	private String city;
	private ArrayList<Report> reports = new ArrayList<>();
	private ArrayList<Citizen> citizens = new ArrayList<>();
	private ArrayList<CityAdmin> admins = new ArrayList<>();


	public Board() { 
		setBoardID(++count);
	}	

	public String toString() {
		return "Board of "+city+" .";
	}

	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}

	public int getBoardID() {
		return boardID;
	}

	void addReport(Report report) {
		reports.add(report);
	}

	void addCitizen(Citizen citizen) {
		citizens.add(citizen);
	}

	void addAdmin(CityAdmin admin) {
		admins.add(admin);
	}

	boolean isACitizen(Citizen citizenToCheck) {
		return this.citizens.contains(citizenToCheck);
	}

	// prints a list of all board's reports (- ID. USER posted REPORT_TITLE) format.
	void printReports() {
		for( int i =0; i < reports.size();i++) {
			System.out.println("-"+reports.get(i).getReportID()+" . "+reports.get(i).toString());
		}
	}

	// prints a list of all citizens of the city (- ID. NAME SURNAME) format.
	void printCitizens() {
		System.out.println("There are "+citizens.size()+" citizens.");
		for( int i =0; i < citizens.size();i++) {
			System.out.println("-"+citizens.get(i).getCitizenID()+" . "+citizens.get(i).toString());
		}
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public ArrayList<Report> getReports() {
		return reports;
	}


	public void setReports(ArrayList<Report> reports) {
		this.reports = reports;
	}

	public ArrayList<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(ArrayList<Citizen> citizens) {
		this.citizens = citizens;
	}

	public ArrayList<CityAdmin> getAdmins() {
		return admins;
	}

	public void setAdmins(ArrayList<CityAdmin> admins) {
		this.admins = admins;
	}

}

