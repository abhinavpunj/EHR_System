package edu.neu.bean;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "UserAccount")
public class UserAccountBean {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PersonId")
	private PersonBean person;
	
	@NotNull(message="Name is a required field")
	@Column(name = "username")
	private String username;
	
	@NotNull(message="Password is a required field")
	@Column(name = "password")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RoleId")
	private RoleBean role;
	
	public PersonBean getPerson() {
		return person;
	}
	public void setPerson(PersonBean person) {
		this.person = person;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleBean getRole() {
		return role;
	}
	public void setRole(RoleBean role) {
		this.role = role;
	}
	
	
}
