package edu.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import edu.neu.bean.EncounterBean;
import edu.neu.bean.PatientBean;
import edu.neu.bean.PersonBean;
import edu.neu.bean.VitalSignBean;

//@Component
public class DoctorDAO extends DAO {
	
	public void updateDiagnosis(EncounterBean encounter)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try 
		{
			conn = getConnection();
			String sql = "UPDATE encounter SET doctor_name = ?, diagnosis = ?, status = ? WHERE encounter_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, encounter.getDoctor());
			stmt.setString(2, encounter.getDiagnosis());
			stmt.setInt(3, encounter.getEncounterId());
			stmt.setString(4, "Closed");
			
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public EncounterBean getVitalSignDetails(EncounterBean encounter)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		PreparedStatement stmt4 = null;
		ResultSet rs = null;
		String sql = null;
		try 
		{
			conn = getConnection();
			sql = "SELECT v.temp, v.pulse, v.bloodpreesure, v.glucose, v.respiratoryrate, v.weight, v.height, v.bmi"
					+ " FROM vitalsign v INNER JOIN encounter e ON e.vitalsign_id = v.VitalSign_Id WHERE e.encounter_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, encounter.getEncounterId());
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				VitalSignBean vs = new VitalSignBean();
				vs.setTemp(rs.getFloat("temp"));
				vs.setPulse(rs.getInt("pulse"));
				vs.setBloodPressure(rs.getInt("bloodpreesure"));
				vs.setGlucose(rs.getInt("glucose"));
				vs.setRespRate(rs.getInt("respiratoryrate"));
				vs.setWeight(rs.getFloat("weight"));
				vs.setHeight(rs.getFloat("height"));
				vs.setBmi(rs.getInt("bmi"));
				encounter.setVitalSign(vs);
			}
			
			sql = "SELECT a.name FROM allergies a INNER JOIN encounter e ON a.encounter_id = e.encounter_id "
					+ "WHERE e.encounter_id = ?";
			stmt2 = conn.prepareStatement(sql);
			stmt2.setInt(1, encounter.getEncounterId());
			rs = stmt2.executeQuery();
			
			encounter.setAllergies(new ArrayList<String>());
			while(rs.next())
			{
				encounter.getAllergies().add(rs.getString("name"));
			}
			
			sql = "SELECT a.name FROM medication a INNER JOIN encounter e ON a.encounter_id = e.encounter_id "
					+ "WHERE e.encounter_id = ?";
			stmt3 = conn.prepareStatement(sql);
			stmt3.setInt(1, encounter.getEncounterId());
			rs = stmt3.executeQuery();
			
			encounter.setActiveMeds(new ArrayList<String>());
			while(rs.next())
			{
				encounter.getActiveMeds().add(rs.getString("name"));
			}
			
			sql = "SELECT a.name FROM symptoms a INNER JOIN encounter e ON a.encounter_id = e.encounter_id "
					+ "WHERE e.encounter_id = ?";
			stmt4 = conn.prepareStatement(sql);
			stmt4.setInt(1, encounter.getEncounterId());
			rs = stmt4.executeQuery();
			
			encounter.setSymptoms(new ArrayList<String>());			
			while(rs.next())
			{
				encounter.getSymptoms().add(rs.getString("name"));
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				stmt2.close();
				stmt3.close();
				stmt4.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return encounter;
	}
	
	public PersonBean getPatientDetails(PersonBean doc)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		try {
			String sql = "Select name FROM person WHERE Person_Id = ?";
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, doc.getPersonId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				doc.setName(rs.getString("name"));
			}
			
			String sql2 = "select a.patient_Id, a.name, a.age, a.phone, a.gender, "
					+ "b.encounter_id, b.chiefComplaint, b.doctor_name, b.diagnosis, b.status"
					+ " from patientprofile a inner join encounter b on a.patient_id = b.pateint_id where a.patient_id = ?";
			stmt2 = conn.prepareStatement(sql2);
			for(PatientBean p : doc.getPatients())
			{
				stmt2.setInt(1, p.getPatientId());
			}
			rs = stmt2.executeQuery();
			
			
				for(PatientBean p : doc.getPatients())
				{
					p.setEncounterHistory(new ArrayList<EncounterBean>());
					while(rs.next())
					{
						p.setName(rs.getString("name"));
						p.setGender(rs.getString("gender"));
						p.setAge(rs.getInt("age"));
						p.setPhone(rs.getInt("phone"));
						EncounterBean enc = new EncounterBean();
						enc.setEncounterId(rs.getInt("encounter_id"));
						enc.setChiefComplaint(rs.getString("chiefComplaint"));
						enc.setDoctor(rs.getString("doctor_name"));
						enc.setDiagnosis(rs.getString("diagnosis"));
						enc.setStatus(rs.getString("status"));
						p.getEncounterHistory().add(enc);
					}
				}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				stmt2.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return doc;
	}

	public PersonBean getDoctorDetails(PersonBean doc)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		try 
		{
			String sql = "Select name FROM person WHERE Person_Id = ?";
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, doc.getPersonId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				doc.setName(rs.getString("name"));
			}
			
			String sql2 = "Select patient_id as patientId, name FROM patientprofile";
			stmt2 = conn.prepareStatement(sql2);
			rs = stmt2.executeQuery();
			
			doc.setPatients(new ArrayList<PatientBean>());
			while(rs.next())
			{
				PatientBean p = new PatientBean();
				p.setPatientId(rs.getInt("patientId"));
				p.setName(rs.getString("name"));
				doc.getPatients().add(p);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				stmt2.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return doc;
	}
}
