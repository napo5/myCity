package myCity;

import java.util.ArrayList;


public class Report {
	
	
	private static int count = 1;
	private int reportID;
	
	private String description;
	private ArrayList<Comment> comments;
	private ReportState state;
	private User author;
	private Task task;
	
	
	
	
	
	
	public Report(String description, ArrayList<Comment> comments, ReportState state, User author) {
		super();
		this.description = description;
		this.comments = comments;
		this.state = state;
		this.author = author;
		setReportID(++count);
		
	}


	void addComment(Comment comment) {
		comments.add(comment);
	}

	
	public String toString() {
		return author.getName()+" "+author.getSurname()+" posted (post nr."+reportID+" ): "+this.description;
		
	}
	
	
	public int getReportID() {
		return reportID;
	}


	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ReportState getState() {
		return state;
	}
	public void setState(ReportState state) {
		this.state = state;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}


	public Task getTask() {
		return task;
	}


	public void setTask(Task task) {
		this.task = task;
	}
	

}
