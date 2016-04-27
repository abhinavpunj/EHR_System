package edu.neu.test;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.neu.bean.DiagnosisBean;
import edu.neu.bean.DrugBean;
import edu.neu.bean.LabPersonBean;
import edu.neu.bean.PersonBean;
import edu.neu.bean.RoleBean;
import edu.neu.bean.UserAccountBean;
import edu.neu.hibernate.HibernateUtil;


public class TestMain {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		RoleBean docRole = new RoleBean();
		docRole.setRoleName("Doctor");
		
		RoleBean nurseRole = new RoleBean();
		nurseRole.setRoleName("Nurse");
		
		RoleBean labRole = new RoleBean();
		labRole.setRoleName("LabTechnician");
		
		PersonBean person = new PersonBean();
		person.setName("Abhinav Punj");
		
		UserAccountBean ua = new UserAccountBean();
		ua.setUsername("abhinavpunj");
		ua.setPassword("abc");
		ua.setPerson(person);
		ua.setRole(docRole);
		
		PersonBean nurse = new PersonBean();
		nurse.setName("Nurse");
		
		UserAccountBean ua2 = new UserAccountBean();
		ua2.setUsername("nurse");
		ua2.setPassword("abc");
		ua2.setPerson(nurse);
		ua2.setRole(nurseRole);
		
		LabPersonBean lab = new LabPersonBean();
		lab.setName("lab");
		
		UserAccountBean ua3 = new UserAccountBean();
		ua3.setUsername("lab");
		ua3.setPassword("abc");
		ua3.setPerson(lab);
		ua3.setRole(labRole);
		
		DrugBean d1 = new DrugBean();
		d1.setDrugName("drug1");
		d1.setComponents(new ArrayList<String>());
		d1.getComponents().add("sulphur");
		d1.getComponents().add("paracetamol");
		
		DrugBean d2 = new DrugBean();
		d2.setDrugName("drug2");
		d2.setComponents(new ArrayList<String>());
		d2.getComponents().add("ibuprofen");
		
		DrugBean d3 = new DrugBean();
		d3.setDrugName("drug3");
		d3.setComponents(new ArrayList<String>());
		d3.getComponents().add("sulphur");
		d3.getComponents().add("morphine");
		
		DiagnosisBean db1 = new DiagnosisBean();
		db1.setDiagnosisName("Cancer");
		db1.setEduLink("http://www.cancer.gov/");
		
		DiagnosisBean db2 = new DiagnosisBean();
		db2.setDiagnosisName("High Cholestrol");
		db2.setEduLink("http://www.nhlbi.nih.gov/health/resources/heart/heart-cholesterol-hbc-what-html");
		
		DiagnosisBean db3 = new DiagnosisBean();
		db3.setDiagnosisName("Influenza");
		db3.setEduLink("http://www.cdc.gov/flu/");
		
		DiagnosisBean db4 = new DiagnosisBean();
		db4.setDiagnosisName("Migraine");
		db4.setEduLink("http://www.webmd.com/migraines-headaches/");
		
		session.save(db1);
		session.save(db2);
		session.save(db3);
		session.save(db4);
		
		session.save(docRole);
		session.save(nurseRole);
		session.save(labRole);
		session.save(person);
		session.save(nurse);
		session.save(lab);
		session.save(ua);
		session.save(ua2);
		session.save(ua3);
		
		session.save(d1);
		session.save(d2);
		session.save(d3);
		
		t.commit();
		session.close();
		//after close session detach state
		System.out.println("success");

	}

}
