package edu.neu.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




import org.springframework.stereotype.Component;

import edu.neu.bean.EncounterBean;
import edu.neu.bean.PatientBean;
import edu.neu.bean.UserAccountBean;

@Component
public class PatientDAO extends DAO {

	public boolean createPatient(PatientBean patient)
	{
		try 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			
			session.save(patient);
			t.commit();
			session.close();
			
			return true;
			
		}
		catch (HibernateException e) 
        {
            try {
				throw new Exception("Could not register Patient " + patient.getName(), e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		return false;
	}
	
	public PatientBean searchPatient(PatientBean patient) 
	{
		Query q = getSession().createQuery("from PatientBean where patientId = :patientId1");

        q.setInteger("patientId1", patient.getPatientId());
        patient = (PatientBean) q.uniqueResult();
        
        return patient;
	}
	
	public void addEncounterData(EncounterBean encounter) 
	{
		try 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			encounter.setPatientId(searchPatient(encounter.getPatientId()));
			
			session.save(encounter);
			t.commit();
			session.close();
			
		}
		catch (HibernateException e) 
        {
            try {
				throw new Exception("Could not create encounter", e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
	}
}