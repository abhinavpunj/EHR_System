package edu.neu.bean;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "patient")
public class PatientBean {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patientId")
	private int patientId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private int phone;
	
	@Transient
	private ArrayList<EncounterBean> encounterHistory = new ArrayList<EncounterBean>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	public ArrayList<EncounterBean> getEncounterHistory() {
		return encounterHistory;
	}
	public void setEncounterHistory(ArrayList<EncounterBean> encounterHistory) {
		this.encounterHistory = encounterHistory;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

}
