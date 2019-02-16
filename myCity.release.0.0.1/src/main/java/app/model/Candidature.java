package app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CANDIDATURE")
public class Candidature {

	@GeneratedValue
    @Id
    @Column(name = "ID")
    private long id;
    
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
    private Person people;
    
	@ManyToOne
	@JoinColumn(name = "TASK_ID")
    private Task tasks;

	public Candidature() {
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public Person getPeople() {
		return people;
	}
	public void setPeople(Person people) {
		this.people = people;
	}

	public Task getTasks() {
		return tasks;
	}
	public void setTasks(Task tasks) {
		this.tasks = tasks;
	}
	
}
