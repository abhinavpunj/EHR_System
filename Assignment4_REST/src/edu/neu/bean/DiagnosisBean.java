package edu.neu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Diagnosis")
public class DiagnosisBean {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diagnosisId")
	private int diagnosisId;
	
	@Column(name = "diagnosisName")
	private String diagnosisName;
	
	@Column(name = "eduLink")
	private String eduLink;
	
	@Transient
	private PatientBean patient;

	public PatientBean getPatient() {
		return patient;
	}

	public void setPatient(PatientBean patient) {
		this.patient = patient;
	}

	public int getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getEduLink() {
		return eduLink;
	}

	public void setEduLink(String eduLink) {
		this.eduLink = eduLink;
	}
	
	
}
