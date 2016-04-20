package edu.neu.bean;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Person")
public class PersonBean {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PersonId")
	private int personId;
	
	@Column(name = "Name")
	private String name;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PersonId")
	private UserAccountBean userAccount;*/
	private String role;
	
	@Transient
	private ArrayList<PatientBean> patients = new ArrayList<PatientBean>();
	
	public ArrayList<PatientBean> getPatients() {
		return patients;
	}
	public void setPatients(ArrayList<PatientBean> patients) {
		this.patients = patients;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public UserAccountBean getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccountBean userAccount) {
		this.userAccount = userAccount;
	}*/
	
	
}
