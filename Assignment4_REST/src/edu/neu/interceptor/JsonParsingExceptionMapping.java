package edu.neu.interceptor;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.JsonParseException;
import org.springframework.stereotype.Component;

@Provider
@Component
public class JsonParsingExceptionMapping implements ExceptionMapper<JsonParseException> {

	@Override
	public Response toResponse(JsonParseException exception) {
		// TODO Auto-generated method stub
        return Response.status(Response.Status.BAD_REQUEST).build();
	}

}
