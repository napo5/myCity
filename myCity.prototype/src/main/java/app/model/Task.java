package app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "POINTS")
	private int points;
	
	@Column(name = "EXP")
	private int exp;
	
	@OneToOne
	@JoinColumn(name = "REPORT_ID")
	private Report report;
	
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
	
	
}


