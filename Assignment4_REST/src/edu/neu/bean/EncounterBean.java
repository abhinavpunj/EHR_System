package edu.neu.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
/*	@Column(name = "dateUpdated")
	private Date dateUpdated = new Date();*/
	
	@Column(name = "diagnosis")
	private String diagnosis;
	
	@Column(name = "status")
	private String status;
	
	@ElementCollection
	@CollectionTable(name = "allergies")
	private List<String> allergies;
	
	@ElementCollection
	@CollectionTable(name = "symptoms")
	private List<String> symptoms;
	
	@ElementCollection
	@CollectionTable(name = "activeMeds")
	private List<String> activeMeds;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "encounter_drug", joinColumns = { 
			@JoinColumn(name = "encounterId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "drugId", 
					nullable = false, updatable = false) })
	private Set<DrugBean> prescription;
	
	public Set<DrugBean> getPrescription() {
		return this.prescription;
	}
	public void setPrescription(Set<DrugBean> prescription) {
		this.prescription = prescription;
	}
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
