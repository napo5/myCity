package myCity;

import java.util.Date;

public class Comment {

	private String description;
	private User author;
	private int likes;
	private int dislikes;
	private Date date;
	
	
	
	public Comment(String description, User author, int likes, int dislikes, Date date) {
		super();
		this.description = description;
		this.author = author;
		this.likes = likes;
		this.dislikes = dislikes;
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
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
}