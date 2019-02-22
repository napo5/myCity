package app.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TASK")
public class Task {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TITLE")
	private String Title;
	
	@Column(name = "DESCRIPTION", columnDefinition ="VARCHAR(300)")
	private String description;
	
	@Column(name = "POINTS", columnDefinition ="VARCHAR(10000)")
	private int points;
	
	@Column(name = "EXP", columnDefinition ="VARCHAR(10000)")
	private int exp;
	
	@Column(name = "STATE")
	private String State;
	
	@OneToOne
	@JoinColumn(name = "REPORT_ID")
	private Report report;
	
	@ManyToOne
	@JoinColumn(name = "WORKER_ID")
	private Person worker;
	
	@OneToMany(mappedBy="tasks", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Candidature.class)
    private List<Candidature> candidature;
	
	public Task() {
		
	}
	
	public Task(String title,String description,int points, int exp) {
		this.Title = title;
		this.description = description;
		this.points = points;
		this.exp = exp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Person getWorker() {
		return worker;
	}

	public void setWorker(Person worker) {
		this.worker = worker;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
	
	public String toString() {
		return this.Title;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public List<Candidature> getCandidature() {
		return candidature;
	}

	public void setCandidature(List<Candidature> candidature) {
		this.candidature = candidature;
	}
	
	public String getWorkerFullName() {	
		return this.worker != null ? this.worker.getName() + " " + this.worker.getSurname() : "";
	}
}


