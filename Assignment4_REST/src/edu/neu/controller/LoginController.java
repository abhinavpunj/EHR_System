package edu.neu.controller;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.validation.ValidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.neu.bean.PersonBean;
import edu.neu.bean.UserAccountBean;
import edu.neu.hibernate.LoginDAO;;

@Controller
@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {

	@Autowired
	private LoginDAO loginDao;
	
	@POST
	@PermitAll
	public Response login(@Valid UserAccountBean user)
	{
		PersonBean person = loginDao.authenticate(user).getPerson();
		//person.setUserAccount(new UserAccountBean());
		return Response.ok().header("AUTH_KEY", person.getRole().toLowerCase()).entity(person).build();
		//return person;
	}
}
