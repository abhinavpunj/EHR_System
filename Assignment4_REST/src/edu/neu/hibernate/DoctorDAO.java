package edu.neu.hibernate;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import edu.neu.bean.EncounterBean;
import edu.neu.bean.PatientBean;
import edu.neu.bean.PersonBean;
import edu.neu.bean.UserAccountBean;

@Component
public class DoctorDAO extends DAO {

	public PersonBean getDoctorDetails(PersonBean doc)
	{
		Query q = getSession().createQuery("from PersonBean where personId = :personId1");
		q.setInteger("personId1", doc.getPersonId());
        doc = (PersonBean) q.uniqueResult();
		
        Query q2 = getSession().createQuery("from PatientBean");
        doc.setPatients((ArrayList<PatientBean>) q2.list());
		return doc;
	}
	
	public PersonBean getPatientDetails(PersonBean doc)
	{
		Query qu = getSession().createQuery("from PersonBean where personId = :personId1");
		qu.setInteger("personId1", doc.getPersonId());
        doc.setName(((PersonBean) qu.uniqueResult()).getName());
        
		Query q = getSession().createQuery("from PatientBean where patientId = :patientId1");
		q.setInteger("patientId1", doc.getPatients().get(0).getPatientId());
        doc.setPatients((ArrayList<PatientBean>) q.list());
        
        Query q2 = getSession().createQuery("from EncounterBean where patientId = :patientId1");
        q2.setInteger("patientId1", doc.getPatients().get(0).getPatientId());
        doc.getPatients().get(0).setEncounterHistory((ArrayList<EncounterBean>) q2.list());
        
        return doc;
	}
	
	public EncounterBean getVitalSignDetails(EncounterBean encounter)
	{
		Query q = getSession().createQuery("from EncounterBean where encounterId = :encounterId1");
		q.setInteger("encounterId1", encounter.getEncounterId());
		encounter = (EncounterBean) q.uniqueResult();
		
		return encounter;
	}
	
	public void updateDiagnosis(EncounterBean encounter)
	{
		Query q = getSession().createQuery("from EncounterBean where encounterId = :encId");
		q.setInteger("encId", encounter.getEncounterId());
		EncounterBean temp = (EncounterBean) q.uniqueResult();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		temp.setDoctor(encounter.getDoctor());
		temp.setDiagnosis(encounter.getDiagnosis());
		
		session.merge(temp);
		t.commit();
		session.close();
	}
}
