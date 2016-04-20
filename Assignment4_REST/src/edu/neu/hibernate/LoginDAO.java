package edu.neu.hibernate;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;



import org.springframework.stereotype.Component;

import edu.neu.bean.PatientBean;
import edu.neu.bean.PersonBean;
import edu.neu.bean.UserAccountBean;

@Component
public class LoginDAO extends DAO {

	public UserAccountBean authenticate(UserAccountBean user)
	{
		try 
        {
        	Query q = getSession().createQuery("from UserAccountBean where username = :username1 and password = :password1");
	        q.setString("username1", user.getUsername());
	        q.setString("password1", user.getPassword());
	        user = (UserAccountBean) q.uniqueResult();
	        user.getPerson().setRole(user.getRole().getRoleName());
	        
	        Query q2 = getSession().createQuery("from PatientBean");
	        user.getPerson().setPatients((ArrayList<PatientBean>)q2.list());
	        
        } 
        catch (HibernateException e) 
        {
            try {
				throw new Exception("Could not get user " + user.getUsername(), e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		
		return user;
	}
}
