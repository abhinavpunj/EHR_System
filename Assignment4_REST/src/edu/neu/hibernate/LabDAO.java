package edu.neu.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import edu.neu.bean.EncounterBean;
import edu.neu.bean.LabRequestBean;

@Component
public class LabDAO extends DAO {

	public ArrayList<EncounterBean> getEncounterIDs(int patientId){
		
		Query q = getSession().createQuery("FROM EncounterBean where patientId = :patientId1 AND status = :stat");
        q.setInteger("patientId1", patientId);
        q.setString("stat", "Open");
         return (ArrayList<EncounterBean>) q.list();
	}
	
	public LabRequestBean orderLabTest(LabRequestBean labOrder){
		try 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			labOrder.setStatus("Not Started");
			
			session.save(labOrder);
			
			t.commit();
			session.close();
			
		}
		catch (HibernateException e) 
        {
            try {
				throw new Exception("Could not register Patient " + labOrder.getTestName(), e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		return labOrder;
	}
	
	public ArrayList<LabRequestBean> getOrders(int patientId){
		ArrayList<EncounterBean> encId = getEncounterIDs(patientId);
		List<Integer> Ids = new ArrayList<Integer>();
		for(EncounterBean e : encId)
			Ids.add(e.getEncounterId());
		Query q = getSession().createQuery("FROM LabRequestBean WHERE encounterId IN (:eId)");
		
		q.setParameterList("eId", Ids);
		
		return (ArrayList<LabRequestBean>) q.list();
	}
	public ArrayList<LabRequestBean> getOrders(){

		Query q = getSession().createQuery("FROM LabRequestBean");
		
		return (ArrayList<LabRequestBean>) q.list();
	}
}
