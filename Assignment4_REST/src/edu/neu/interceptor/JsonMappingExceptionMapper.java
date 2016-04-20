package edu.neu.interceptor;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Component;

@Provider
@Component
public class JsonMappingExceptionMapper implements ExceptionMapper<JsonMappingException> {
    
	@Override
    public Response toResponse(JsonMappingException exception) {
    	
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}