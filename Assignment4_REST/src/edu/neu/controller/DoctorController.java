package edu.neu.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.validation.ValidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.neu.bean.DiagnosisBean;
import edu.neu.bean.DrugBean;
import edu.neu.bean.EncounterBean;
import edu.neu.bean.PatientBean;
import edu.neu.bean.PersonBean;
import edu.neu.hibernate.DoctorDAO;
import edu.neu.hibernate.LabDAO;

@Controller
@Path("/doctor")
@ValidateRequest
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorController {

	@Autowired
	DoctorDAO doctorDao;
	
	@GET
	@RolesAllowed("doctor")
	@Path("/{personId}")
	public PersonBean getDoctorHome(@PathParam(value = "personId") int personId)
	{
		PersonBean doctor = doctorDao.getDoctorDetails(personId);
		return doctor;
	}
	
	@GET
	@RolesAllowed("doctor")
	@Path("/patientDetails/{personId}/{patientId}")
	public Response getPatientDetails(@PathParam(value = "patientId") int patientId,
			@PathParam(value = "personId") int personId)
	{
		PersonBean doctor = new PersonBean();
		doctor.setPersonId(personId);
		doctor.setPatients(new ArrayList<PatientBean>());
		PatientBean p = new PatientBean();
		p.setPatientId(patientId);
		doctor.getPatients().add(p);
		doctor = doctorDao.getPatientDetails(doctor);
		return Response.ok().entity(doctor).build();
	}
	
	@POST
	@Path("/vitalsignDetails")
	@RolesAllowed("doctor")
	public EncounterBean getVitalSign(@Valid EncounterBean encounter)
	{
		encounter = doctorDao.getVitalSignDetails(encounter);
		return encounter;
	}
	
	@PUT
	@RolesAllowed("doctor")
	@Path("/updateDiagnosis")
	public void updateDiagnosis(@Valid EncounterBean encounter)
	{
		doctorDao.updateDiagnosis(encounter);
	}
	
	@GET
	@RolesAllowed("doctor")
	@Path("/getPrescriptions/{patientId}")
	public ArrayList<EncounterBean> getPrescriptions(@PathParam(value = "patientId") int patientId){
		ArrayList<EncounterBean> drugs = doctorDao.getAllEncounters(patientId);
		return drugs;
	}
	
	@GET
	@RolesAllowed("doctor")
	@Path("/getDrugs")
	public ArrayList<DrugBean> getDrugs(){
		ArrayList<DrugBean> drugs = doctorDao.getAllDrugs();
		return drugs;
	}
	
	@GET
	@RolesAllowed({"doctor", "nurse"})
	@Path("/getDiagnosis")
	public ArrayList<DiagnosisBean> getDiagnosis(){
		ArrayList<DiagnosisBean> diagnosis = doctorDao.getAllDiagnosis();
		return diagnosis;
	}
	
	@POST
	@RolesAllowed("doctor")
	@Path("/checkAllergy")
	public ArrayList<DrugBean> checkDrugAllergy(EncounterBean encounter){
		
		return doctorDao.checkDrugAllergy(encounter);
	}
	
	@POST
	@RolesAllowed("doctor")
	@Path("/addPrescription")
	public ArrayList<EncounterBean> addPrescription(EncounterBean encounter){
		
		return doctorDao.addPrescription(encounter);
	}
	
}
