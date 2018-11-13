package myCity;

import java.util.ArrayList;
import java.util.Date;


public class Report {
	
	
	private static int count = 0;
	private int reportID;
	
	private String title;
	private String description;
	private ArrayList<Comment> comments = new ArrayList<Comment>();
	private ReportState state = ReportState.REGULAR;
	private Date date;
	private User author;
	private Task task;
	
	
	
	
	
	
	public Report(String title,String description, User author) {
		
		this.setTitle(title);
		this.description = description;
		this.author = author;
		Date now = new Date();
		this.date = now;
		setReportID(++count);
		
	}

	public Report(){

	}


	void addComment(Comment comment) {
		comments.add(comment);
	}

	
	public String toString() {
		return author.getName()+" "+author.getSurname()+" posted : "+this.title;
		
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	public void printComments() {

			System.out.println("There are "+comments.size()+" comments.");

			for( int i =0; i < comments.size();i++) {
				System.out.println("-"+comments.get(i).getCommentID()+" . "+comments.get(i).toString());
			
		}
	}
	

}
