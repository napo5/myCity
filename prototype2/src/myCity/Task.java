package myCity;

public class Task {
	
	private String description;
	private int points;
	private int exp;
	
	
	
	
	public Task(String description, int points, int exp) {
		super();
		this.description = description;
		this.points = points;
		this.exp = exp;
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




	

}
