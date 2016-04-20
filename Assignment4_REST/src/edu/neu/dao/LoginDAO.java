package edu.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import edu.neu.bean.PersonBean;
import edu.neu.bean.RoleBean;
import edu.neu.bean.UserAccountBean;

//@Component
public class LoginDAO extends DAO {

	public PersonBean authenticate(UserAccountBean user)
	{
		PersonBean person = new PersonBean();
		Connection conn = getConnection();
		Statement stmt = null;
		try 
		{
			stmt = conn.createStatement();
			String sql = "SELECT p.Person_Id As personId, p.name AS name, r.Role_Name As roleName FROM person p INNER JOIN useraccount u on p.Person_Id = u.person_id"
					+ " INNER JOIN role r on r.Role_Id = u.Role_Id"
					+ " WHERE u.username='" + user.getUsername() + "' AND u.password='" + user.getPassword() + "';";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				person.setPersonId(rs.getInt("personId"));
				person.setName(rs.getString("name"));
				person.setRole(rs.getString("roleName"));
				RoleBean role = new RoleBean();
				role.setRoleName(rs.getString("roleName"));
				user.setRole(role);
				//person.setUserAccount(user);
			}
			
			rs.close();
			stmt.close();
		} 
		catch (SQLException e) {
			// TODO: handle exception
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return person;
	}
}
