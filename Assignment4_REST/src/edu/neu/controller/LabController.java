package edu.neu.controller;

import java.util.ArrayList;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.spi.validation.ValidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.neu.bean.EncounterBean;
import edu.neu.bean.LabRequestBean;
import edu.neu.bean.PersonBean;
import edu.neu.dao.DoctorDAO;
import edu.neu.hibernate.LabDAO;

@Controller
@ValidateRequest
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/lab")
public class LabController {
	
	@Autowired
	LabDAO labDao;
	
	@GET
	@Path("/getEncounters/{patientId}")
	@RolesAllowed("doctor")
	public ArrayList<EncounterBean> getEncounterID(@PathParam(value = "patientId") int patientId){
		
		return labDao.getEncounterIDs(patientId);
	}
	
	@POST
	@Path("/orderTest")
	@RolesAllowed("doctor")
	public LabRequestBean orderTest(LabRequestBean labOrder){
		labDao.orderLabTest(labOrder);
		return labOrder;
	}
		
	@GET
	@Path("/getOrders/{patientId}")
	@RolesAllowed("doctor")
	public ArrayList<LabRequestBean> getLabOrders(@PathParam(value = "patientId") int patientId){
		
		ArrayList<LabRequestBean> result = labDao.getOrders(patientId);
		return result;
	}
	
	@GET
	@Path("/getOrders/{patientId}")
	@RolesAllowed("labtechnician")
 	public ArrayList<LabRequestBean> getAllLabOrders(){
		
		ArrayList<LabRequestBean> result = labDao.getOrders();
		return result;
	}
}
