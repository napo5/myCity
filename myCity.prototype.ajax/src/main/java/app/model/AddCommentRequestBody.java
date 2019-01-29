package app.model;

public class AddCommentRequestBody {
 private String description;
 private String id;
 
 public AddCommentRequestBody() {	 
 }
 
 public AddCommentRequestBody(String description, String id) {
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
