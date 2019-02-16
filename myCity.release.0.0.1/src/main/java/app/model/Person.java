package app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name = "";
	
	@Column(name = "SURNAME")
	private String surname = "";
	
	@Column(name = "EMAIL")
	private String email = "";
	
	@Column(name = "CITY")
	private String city = "";
	
	@Column(name = "COOKIE")
	private String cookie = "";
	
	@Column(name = "POINTS")
	private int points=0;
	
	@Column(name = "EXP")
	private int exp=0;
	
	@Column(name = "ROLE")
	private String role = "citizen";
	
	public static String cityadmin = "cityAdmin";
	public static String citizen = "citizen";
	public static String worker = "worker";

	@OneToMany(mappedBy="author", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Report.class)
	    private List<Report> reports;

	@OneToMany(mappedBy="people", cascade = CascadeType.ALL, fetch = FetchType.LAZY , targetEntity = Candidature.class)
    private List<Candidature> candidature;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Message.class)
    private List<Message> messages;
	
	@OneToMany(mappedBy="worker", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Task.class)
    private List<Task> tasks;
	
	public Person() {
	}

	public String getRole() {
		return role;
	}

	public static String getCityadmin() {
		return cityadmin;
	}

	public static void setCityadmin(String cityadmin) {
		Person.cityadmin = cityadmin;
	}

	public static String getCitizen() {
		return citizen;
	}

	public static void setCitizen(String citizen) {
		Person.citizen = citizen;
	}

	public static String getWorker() {
		return worker;
	}

	public static void setWorker(String worker) {
		Person.worker = worker;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> task) {
		this.tasks = task;
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	public String getCookie() {
		return cookie;
	}

	public String getCity() {
		return city;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public int getPoints() {
		return points;
	}

	public List<Candidature> getCandidature() {
		return candidature;
	}

	public void setCandidature(List<Candidature> candidature) {
		this.candidature = candidature;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}

	// napo

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person( String username, String role ) {
		this.role = role;
		this.username = username;
	}
	 // napo end
	public void addPoints(int points) {
		this.points += points;
	}
	
	public void addExp(int exp) {
		this.exp += exp;
	}
	
	public boolean isAdmin() {
		return this.role.equals(Person.cityadmin) ? true : false;
	}

	public boolean expOrPointsInRange(int points, int exp) {
		return this.points + points <= 10000 && this.exp + exp <= 10000 ? true : false;
	}
}
