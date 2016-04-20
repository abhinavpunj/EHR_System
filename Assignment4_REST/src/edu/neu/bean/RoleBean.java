package edu.neu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Roles")
public class RoleBean {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleId")
	private int roleId;
	
	@Column(name = "RoleName")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
