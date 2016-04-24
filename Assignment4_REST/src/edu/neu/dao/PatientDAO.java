package edu.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;







import edu.neu.bean.EncounterBean;
import edu.neu.bean.PatientBean;

//@Component
public class PatientDAO extends DAO {

	public boolean createPatient(PatientBean patient)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try 
		{
			conn = getConnection();
			String sql = "INSERT INTO patientprofile"
					+ "(name, age, gender, address, phone) VALUES"
					+ "(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, patient.getName());
			stmt.setInt(2, patient.getAge());
			stmt.setString(3, patient.getGender());
			stmt.setString(4, patient.getAddress());
			stmt.setInt(5, patient.getPhone());
			
			stmt.executeUpdate();
			
		} 
		catch (Exception e) {
			return false;
		}
		finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	public PatientBean searchPatient(PatientBean patient) {
		
		String query = "select patient_id, name from patientprofile where patient_id = " + patient.getPatientId();
		
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				patient.setPatientId(rs.getInt(1));
				patient.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return patient;
	}
	
	public void addEncounterData(EncounterBean encounter) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		String query = "insert into encounter(pateint_id, chiefcomplaint, vitalsign_id, status) values (?,?,?,?)";
		String query2 = "insert into vitalSign(respiratoryrate, pulse, weight, bloodpreesure, height, glucose, bmi) values (?,?,?,?,?,?,?)";
		String query3 = "insert into allergies(name, encounter_id) values (?,?)";
		String query4 = "insert into medication(name, encounter_id) values (?,?)";
		String query5 = "insert into symptoms(name, encounter_id) values (?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt2 = conn.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
			pstmt3 = conn.prepareStatement(query3);
			pstmt4 = conn.prepareStatement(query4);
			pstmt5 = conn.prepareStatement(query5);

			pstmt2.setFloat(1, encounter.getVitalSign().getRespRate());
			pstmt2.setFloat(2, encounter.getVitalSign().getPulse());
			pstmt2.setFloat(3, encounter.getVitalSign().getWeight());
			pstmt2.setFloat(4, encounter.getVitalSign().getBloodPressure());
			pstmt2.setFloat(5, encounter.getVitalSign().getHeight());
			pstmt2.setFloat(6, encounter.getVitalSign().getGlucose());
			pstmt2.setFloat(7, encounter.getVitalSign().getBmi());
			pstmt2.executeUpdate();
			int vitalSignId;
			ResultSet rs = pstmt2.getGeneratedKeys();
			rs.next();
			vitalSignId = rs.getInt(1);
			
			//pstmt.setInt(1, encounter.getPatientId());
			//pstmt.setString(2, encounter.getDoctor());
			pstmt.setString(2, encounter.getChiefComplaint());
			pstmt.setInt(3, vitalSignId);
			pstmt.setString(4, "Open");
			pstmt.executeUpdate();
			int encounterId;
			rs = pstmt.getGeneratedKeys();
			rs.next();
			encounterId = rs.getInt(1);
			
			for(String allergy: encounter.getAllergies())
			{
				pstmt3.setString(1, allergy);
				pstmt3.setInt(2, encounterId);
				pstmt3.addBatch();
			}
			
			pstmt3.executeBatch();
			
			for(String med: encounter.getActiveMeds())
			{
				pstmt4.setString(1, med);
				pstmt4.setInt(2, encounterId);
				pstmt4.addBatch();
			}
			
			pstmt4.executeBatch();
			
			for(String sym: encounter.getSymptoms())
			{
				pstmt5.setString(1, sym);
				pstmt5.setInt(2, encounterId);
				pstmt5.addBatch();
			}
			
			pstmt5.executeBatch();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				pstmt2.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
