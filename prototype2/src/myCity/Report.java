package myCity;

import java.util.Vector;

public class Report {
	
	
	private static int count = 0;
	private int reportID;
	
	private String description;
	private Vector<Comment> comments;
	private ReportState state;
	private User author;
	
	
	
	
	
	public Report(String description, Vector<Comment> comments, ReportState state, User author) {
		super();
		this.description = description;
		this.comments = comments;
		this.state = state;
		this.author = author;
		setReportID(++count);
		
	}


	void addComment(Comment comment) {
		comments.addElement(comment);
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
	public Vector<Comment> getComments() {
		return comments;
	}
	public void setComments(Vector<Comment> comments) {
		this.comments = comments;
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
	

}
