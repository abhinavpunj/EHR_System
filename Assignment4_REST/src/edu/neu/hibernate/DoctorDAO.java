package edu.neu.hibernate;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import edu.neu.bean.DrugBean;
import edu.neu.bean.EncounterBean;
import edu.neu.bean.PatientBean;
import edu.neu.bean.PersonBean;
import edu.neu.bean.UserAccountBean;

@Component
public class DoctorDAO extends DAO {

	public PersonBean getDoctorDetails(int personId)
	{
		Query q = getSession().createQuery("from PersonBean where personId = :personId1");
		q.setInteger("personId1", personId);
        PersonBean doc = (PersonBean) q.uniqueResult();
		
/*        Query q2 = getSession().createQuery("from PatientBean");
        doc.setPatients((ArrayList<PatientBean>) q2.list());*/
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
        
        doc.getPatients().get(0).setEncounterHistory(getAllEncounters(doc.getPatients().get(0).getPatientId()));
        
        return doc;
	}
	
	public ArrayList<EncounterBean> getAllEncounters(int patientId)
	{
		Query q2 = getSession().createQuery("from EncounterBean where patientId = :patientId1");
        q2.setInteger("patientId1", patientId);
        return (ArrayList<EncounterBean>) q2.list();
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
	
	/*public ArrayList<DrugBean> getAllPrescriptions(int patientId)
	{
		ArrayList<EncounterBean> encounters = getAllEncounters(patientId);
		Query q = getSession().createQuery("from DrugBean d where EncounterBean.encounterId in (:encs)");
		q.setParameterList("encs", encounters);
		
		return (ArrayList<DrugBean>) q.list();
	}*/
	
	public ArrayList<DrugBean> getAllDrugs()
	{
		Query q = getSession().createQuery("from DrugBean");
		
		return (ArrayList<DrugBean>) q.list();
	}
	
	public ArrayList<DrugBean> checkDrugAllergy(EncounterBean encounter)
	{
		ArrayList<DrugBean> drugAllergy = new ArrayList<DrugBean>();
		for(DrugBean db : encounter.getPrescription())
		{
			boolean flag = false;
			ArrayList<String> comp = new ArrayList<String>();
			for(String c : db.getComponents())
			{
				if(encounter.getAllergies().contains(c))
				{
					comp.add(c);
					flag = true;
				}
			}
			if(flag){
				DrugBean d = new DrugBean();
				d.setDrugName(db.getDrugName());
				d.setComponents(comp);
				drugAllergy.add(d);
			}
				
		}
		
		return drugAllergy;
	}
	
	public ArrayList<EncounterBean> addPrescription(EncounterBean encounter)
	{
		Query q = getSession().createQuery("from EncounterBean where encounterId = :eId");
		q.setInteger("eId", encounter.getEncounterId());
		EncounterBean temp = (EncounterBean) q.uniqueResult();
		for(DrugBean db : temp.getPrescription())
		{
			encounter.getPrescription().add(db);
		}
		
		try 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			
			session.merge(encounter);
			t.commit();
			session.close();
			
		}
		catch (HibernateException e) 
        {
            try {
				throw new Exception("Could not add prescription for encounter " + encounter.getEncounterId(), e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		return getAllEncounters(encounter.getPatientId().getPatientId());
	}
}
