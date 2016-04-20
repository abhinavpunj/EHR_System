package edu.neu.interceptor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.Path;
import javax.validation.Path.Node;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.hibernate.validator.engine.NodeImpl;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.stereotype.Component;

@Component
@Provider
public class ValidationExceptionHandler implements ExceptionMapper<MethodConstraintViolationException> {

	@Override
	public Response toResponse(MethodConstraintViolationException exception) {
		List<Error> errors = new ArrayList<>();
    	MethodConstraintViolationException ex =(MethodConstraintViolationException)exception;
    	Set<MethodConstraintViolation<?>> set =  ex.getConstraintViolations();
    	Iterator<MethodConstraintViolation<?>> it = set.iterator();
    	while(it.hasNext()){
    		MethodConstraintViolation<?> vio = it.next();
    		Path path = vio.getPropertyPath();
    		Iterator<Node> nodeIt=path.iterator();
    		String name=null;
    		while(nodeIt.hasNext()){
    			NodeImpl node= (NodeImpl) nodeIt.next();
    			name=node.asString();
    		}
//    		errors.add("{name:"+name+",msg:"+messageSource.getMessage(vio.getMessageTemplate().substring(1).replace("}", ""),new String[]{""},new Locale("en"))+"}");
//    		errors.add("{propName:"+name+",errorMsg:"+vio.getMessage()+"}");
    		errors.add(new Error(name, vio.getMessage()));


    	}
    	
        return Response.status(Status.BAD_REQUEST).entity(errors).build();
    
	}

}

class Error{
	 
	public Error() {
		// TODO Auto-generated constructor stub
		
	}
	
	

	
	public Error(String propName, String errorMsg) {
		super();
		this.propName = propName;
		this.errorMsg = errorMsg;
	}




	private String propName;
	private String errorMsg;
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getPropName() {
		return propName;
	}
	
	public void setPropName(String propName) {
		this.propName = propName;
	}
}
