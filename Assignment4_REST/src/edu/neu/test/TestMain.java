package edu.neu.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
		
		session.save(docRole);
		session.save(nurseRole);
		session.save(labRole);
		session.save(person);
		session.save(nurse);
		session.save(lab);
		session.save(ua);
		session.save(ua2);
		session.save(ua3);
		
		t.commit();
		session.close();
		//after close session detach state
		System.out.println("success");

	}

}
