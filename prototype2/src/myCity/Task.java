package myCity;

import java.util.Scanner;


public class Task {
	
	private String description;
	private int points;
	private int exp;
	
	
	
	
	public Task(String description, int points, int exp) {

		this.description = description;
		this.points = points;
		this.exp = exp;
	}
	
	public Task() {

		/* let city admin create task from console */
		
		System.out.println("Insert description of the task : ");
		Scanner inputDescription = new Scanner(System.in);
		this.description = inputDescription.nextLine();
		 
		System.out.println("Insert points of the task : ");
		Scanner inputPoints = new Scanner(System.in);
		this.points = inputPoints.nextInt();
		
		System.out.println("Insert exp of the task : ");
		Scanner inputExp = new Scanner(System.in);
		this.points = inputPoints.nextInt();
		
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
