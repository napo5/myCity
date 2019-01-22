package app.model;

public class Proto {
 private String description;
 private String id;
 
 
 
 public Proto() {
	 
 }
 
 public Proto(String description, String id) {
	 this.description = description;
	 this.id = id;
 }
 public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

 
 
}
