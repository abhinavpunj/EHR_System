package edu.neu.bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Drug")
public class DrugBean {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drugId")
	private int drugId;
	
	@Column(name = "drugName")
	private String drugName;
	
	@ElementCollection
	@CollectionTable(name = "components")
	private List<String> components;
	
	/*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "prescription")
	private Set<EncounterBean> encounters;*/

	/*public Set<EncounterBean> getEncounters() {
		return encounters;
	}*/

	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public List<String> getComponents() {
		return components;
	}

	public void setComponents(List<String> components) {
		this.components = components;
	}

/*	public void setEncounters(Set<EncounterBean> encounters) {
		this.encounters = encounters;
	}*/
}
