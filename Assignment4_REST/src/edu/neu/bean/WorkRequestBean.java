package edu.neu.bean;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WorkRequest")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
public class WorkRequestBean {

	@Id	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "WorkId")
	private int workId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sender", nullable = false)
	private PersonBean sender;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "encounterId")
	private EncounterBean encounter;
	
	@Column(name = "updated")
	private Date updated;

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public PersonBean getSender() {
		return sender;
	}

	public void setSender(PersonBean sender) {
		this.sender = sender;
	}

	public EncounterBean getEncounter() {
		return encounter;
	}

	public void setEncounter(EncounterBean encounter) {
		this.encounter = encounter;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
}
