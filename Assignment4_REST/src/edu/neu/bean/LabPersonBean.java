package edu.neu.bean;

import java.util.ArrayList;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity  
@Table(name="LabPerson")  
@AttributeOverrides({  
    @AttributeOverride(name="LabPersonId", column=@Column(name="PersonId")),
    @AttributeOverride(name="name", column=@Column(name="name"))  
}) 
public class LabPersonBean extends PersonBean {

	@Transient
	private ArrayList<LabRequestBean> labRequests = new ArrayList<LabRequestBean>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "LabRequest")
	public ArrayList<LabRequestBean> getLabRequests() {
		return labRequests;
	}

	public void setLabRequests(ArrayList<LabRequestBean> labRequests) {
		this.labRequests = labRequests;
	}
	
	
}
