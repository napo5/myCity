package app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="REPORT")
public class Report {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private Person author;
	@ManyToOne
	@JoinColumn(name = "BOARD_ID")
	private Person board;
	
	@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL, mappedBy = "report")
	private Task task;
	
	public Report() {
		
	}
	public Report(String title, String description) {
		this.title=title;
		this.description=description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Person getAuthor() {
		return author;
	}
	
	public String getAuthorName() {
		return author.getName();
	}
	
	public void setAuthor(Person author) {
		this.author = author;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	
	public boolean hasTask() {
		return this.getTask()!=null ? true : false;
	}
	@Override
	public String toString() {
		return this.title;
	}
}
