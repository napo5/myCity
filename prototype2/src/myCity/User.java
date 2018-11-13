package myCity;

import java.time.LocalDate;

public class User {

	private String name;
	private String surname;
	private LocalDate birthday;
	private String email;

	public User( String name, String surname, LocalDate birthday, String email) {
		
		
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.email = email;
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
	
	
	
	

}
