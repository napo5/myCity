package app.model;

public class createReportRequestBody {

	private String name;
	private String description;
	private String title;
	private String image;
	
	public createReportRequestBody(String name,String description,String title,String image) {
		this.name = name;
		this.title = title;
		this.description = description;
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
}
