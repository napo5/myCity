package app.model;

public class AcceptRefuseTaskRequestBody {

	private String idReport;
	private String idMessage;
	private String value;
	
	public AcceptRefuseTaskRequestBody(String idReport, String idMessage, String value){
		this.idReport = idReport;
		this.idMessage = idMessage;
		this.value = value;
	}
	public String getIdReport() {
		return idReport;
	}
	public void setIdReport(String idReport) {
		this.idReport = idReport;
	}
	public String getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
