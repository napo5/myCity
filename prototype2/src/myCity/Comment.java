package myCity;

import java.util.Date;

public class Comment {
	
	private static int count = 0;
	private int commentID;
	private String description;
	private Citizen author;
	private int likes;
	private int dislikes;
	private Date date;

	
	public Comment(String description, Citizen author) {
		this.description = description;
		this.author = author;
		Date now = new Date();
		this.date = now;
		setCommentID(++count);
	}

    @Override
    public String toString() {
        return author.getName()+author.getSurname()+" commented: "+description;
    }

    public String getDescription() {
		return description;
	}
    
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Citizen getAuthor() {
		return author;
	}
	
	public void setAuthor(Citizen author) {
		this.author = author;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public int getDislikes() {
		return dislikes;
	}
	
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	
}