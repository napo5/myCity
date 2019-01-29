package app.model;


import java.text.SimpleDateFormat;


import java.util.Date;
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
@Table(name="REPORT")
public class Report {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION", columnDefinition ="VARCHAR(1000)")
	private String description;
	@Column(name = "DATE")
	private String date = Date();
	@Column(name = "IMAGE")
	private String image = "";
	@Column(name = "VIEWS")
	private int views = 0;
	
	
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private Person author;
	
	@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL, mappedBy = "report")
	private Task task;
	
	@OneToMany(mappedBy="report", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Comment.class)
    private List<Comment> comments;
	
	public Long getId() {
		return id;
	}
	private String Date() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format(new Date());
		return dateString;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public void addViews() {
		this.views = this.views + 1;
	}
	public String getDate() {
		return date;
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
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	public void setDate(String date) {
		this.date = date;
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
