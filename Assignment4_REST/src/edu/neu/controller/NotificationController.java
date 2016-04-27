package edu.neu.controller;

import java.util.ArrayList;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.neu.bean.EncounterBean;
import edu.neu.bean.PatientBean;
import edu.neu.hibernate.EmailNotification;
import edu.neu.hibernate.PatientDAO;

@Controller
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/notify")
public class NotificationController {

	@Autowired
	EmailNotification notification;
	
	@Autowired
	PatientDAO patientDao;
	
	@POST
	@RolesAllowed("nurse")
	@Path("/send")
	public boolean sendEmail(PatientBean patient)
	{
		if(patient.getEncounterHistory().isEmpty())
			patient.getEncounterHistory().add(patientDao.getLatestEncounter(patient));
		return notification.notifyByMail(patient);
	}
	
	@POST
	@RolesAllowed("doctor")
	@Path("/sendEncounter")
	public boolean sendEncounterEmail(EncounterBean encounter)
	{
		PatientBean patient = new PatientBean();
		patient.setEncounterHistory(new ArrayList<EncounterBean>());
		patient.getEncounterHistory().add(encounter);
		patient.setEmail(encounter.getPatientId().getEmail());
		return notification.notifyByMail(patient);
	}
}
