package edu.neu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vitalSign")
public class VitalSignBean {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vitalSignId")
	private int vitalSignId;
	
	@Column(name = "temp")
	private float temp;
	
	@Column(name = "pulse")
	private int pulse;
	
	@Column(name = "bloodPressure")
	private int bloodPressure;
	
	@Column(name = "glucose")
	private int glucose;
	
	@Column(name = "respRate")
	private int respRate;
	
	@Column(name = "weight")
	private float weight;
	
	@Column(name = "height")
	private float height;
	
	@Column(name = "bmi")
	private int bmi;
	
	public int getVitalSignId() {
		return vitalSignId;
	}
	public void setVitalSignId(int vitalSignId) {
		this.vitalSignId = vitalSignId;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public int getPulse() {
		return pulse;
	}
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	public int getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public int getGlucose() {
		return glucose;
	}
	public void setGlucose(int glucose) {
		this.glucose = glucose;
	}
	public int getRespRate() {
		return respRate;
	}
	public void setRespRate(int respRate) {
		this.respRate = respRate;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public int getBmi() {
		return bmi;
	}
	public void setBmi(int bmi) {
		this.bmi = bmi;
	}
	
	
}
