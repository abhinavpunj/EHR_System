package edu.neu.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Encounter")
public class EncounterBean {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId", nullable = false)
	private PatientBean patientId;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "encounterId")
	private int encounterId;
	
	@Column(name = "chiefComplaint")
	private String chiefComplaint;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vitalSignId")
	private VitalSignBean vitalSign;
	
	@Column(name = "doctor")
	private String doctor;
	
	//private Date date;
	
	@Column(name = "diagnosis")
	private String diagnosis;
	
	@ElementCollection
	@CollectionTable(name = "allergies")
	private List<String> allergies;
	
	@ElementCollection
	@CollectionTable(name = "symptoms")
	private List<String> symptoms;
	
	@ElementCollection
	@CollectionTable(name = "activeMeds")
	private List<String> activeMeds;
	
	public int getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}
	public PatientBean getPatientId() {
		return patientId;
	}
	public void setPatientId(PatientBean patientId) {
		this.patientId = patientId;
	}
	public String getChiefComplaint() {
		return chiefComplaint;
	}
	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}
	public VitalSignBean getVitalSign() {
		return vitalSign;
	}
	public void setVitalSign(VitalSignBean vitalSign) {
		this.vitalSign = vitalSign;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(ArrayList<String> allergies) {
		this.allergies = allergies;
	}
	public List<String> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(ArrayList<String> symptoms) {
		this.symptoms = symptoms;
	}
	public List<String> getActiveMeds() {
		return activeMeds;
	}
	public void setActiveMeds(ArrayList<String> activeMeds) {
		this.activeMeds = activeMeds;
	}
	
	
}
