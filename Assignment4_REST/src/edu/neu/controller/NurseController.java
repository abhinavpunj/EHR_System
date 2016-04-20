package edu.neu.controller;

import java.util.Date;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mysql.fabric.xmlrpc.base.Data;

import edu.neu.bean.EncounterBean;
import edu.neu.bean.PatientBean;
import edu.neu.hibernate.PatientDAO;

@Controller
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/nurse")
public class NurseController {

	@Autowired
	PatientDAO patientDao;
	
	@POST
	@RolesAllowed("nurse")
	@Path("/registerPatient")
	public void registerPatient(PatientBean patient)
	{
		patientDao.createPatient(patient);
	}
	
	@GET
	@Path("/searchPatient/{pId}")
	@RolesAllowed("nurse")
	public PatientBean searchPatient(@PathParam(value = "pId") int patientId)
	{
		PatientBean patient = new PatientBean();
		patient.setPatientId(patientId);
		patient = patientDao.searchPatient(patient);
		
		return patient;
	}
	
	@POST
	@Path("/addEncounter")
	@RolesAllowed("nurse")
	public void addEncounter(EncounterBean encounter)
	{
		patientDao.addEncounterData(encounter);
	}
		
	
}
