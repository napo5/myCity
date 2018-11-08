package myCity;

import java.util.Date;

public class User {
	
		private static int count = 0;
		private int userID;
	
	
	
	public User(int iD, String name, String surname, String city, Date birthday, String email) {
		
		
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.birthday = birthday;
		this.email = email;
		setUserID(++count);
	}
	
	private String name;
	private String surname;
	private String city;
	private Date birthday;
	private String email;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}
