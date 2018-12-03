package myCity;

public class ApplyRequest {

	private Integer daysToComplete;  //days within i think to complete the task;
	
	public ApplyRequest(int daysToComplete) {
		this.daysToComplete = daysToComplete;
	}
	
	public Integer getDaysToComplete() {
		return this.daysToComplete;
	}

	@Override
	public String toString() {
		return getDaysToComplete() + "";
	}
}
