package edu.neu.bean;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LabRequest")
@AttributeOverrides({  
    @AttributeOverride(name="LabRequestId", column=@Column(name="WorkId"))
}) 
public class LabRequestBean extends WorkRequestBean {

	@Column(name = "testName")
	private String testName;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "result") 
	private String result;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "assignedTo")
	private LabPersonBean assignedTo;

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LabPersonBean getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(LabPersonBean assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	
}
