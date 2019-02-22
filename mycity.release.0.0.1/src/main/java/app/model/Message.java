package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGE")
public class Message {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "SENDER_NAME")
	private String senderName;
	
	@Column(name = "SENDER_SURNAME")
	private String senderSurname;
	
	@Column(name = "SENDER_ROLE")
	private String senderRole;
	
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REPORT_ID")
	private String idReport;
	
	@Column(name = "READ")
	private boolean read = false;
	
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private Person owner;
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderSurname() {
		return senderSurname;
	}
	public void setSenderSurname(String senderSurname) {
		this.senderSurname = senderSurname;
	}
	public String getSenderRole() {
		return senderRole;
	}
	public void setSenderRole(String senderRole) {
		this.senderRole = senderRole;
	}
	public String getIdReport() {
		return idReport;
	}
	public void setIdReport(String idReport) {
		this.idReport = idReport;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	
}
