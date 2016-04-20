package edu.neu.interceptor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import org.jboss.resteasy.util.Base64;
import org.springframework.stereotype.Component;

@Provider
@Component
public class SecurityInterceptor implements PreProcessInterceptor {

	private static final String AUTHORIZATION_PROPERTY = "AUTH_KEY";

	private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401,
			new Headers<Object>());;
	private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource", 403,
			new Headers<Object>());;
	private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR", 500,
			new Headers<Object>());;

	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethod method)
			throws Failure, WebApplicationException {
		// TODO Auto-generated method stub
		
		Method m = method.getMethod();
		if(m.isAnnotationPresent(DenyAll.class)){
			return ACCESS_DENIED;
		}
		
		if(m.isAnnotationPresent(PermitAll.class)){
			return null;
		}
		
		HttpHeaders headers = request.getHttpHeaders();
		// Fetch authorization header
		final List<String> authorization = headers.getRequestHeader(AUTHORIZATION_PROPERTY);

		// If no authorization information present; block access
		if (authorization == null || authorization.isEmpty()) {
			return ACCESS_DENIED;
		}
		
		String encodedValue = authorization.get(0);
		
		if(m.isAnnotationPresent(RolesAllowed.class)){
            RolesAllowed rolesAnnotation = m.getAnnotation(RolesAllowed.class);
            Set<String> allowedRoleSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
            String decodedToken =null;
            try {
            	decodedToken = new String(Base64.decode(encodedValue.getBytes()));
    			
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
            if( ! isUserAllowed(encodedValue, allowedRoleSet))
            {
                return ACCESS_DENIED;
            }
		
		}
		
		return null;
	}
	
	private boolean isUserAllowed(final String role, final Set<String> rolesSet) 
    {
        boolean isAllowed = false;
         
        //Step 1. Fetch password from database and match with password in argument
        //If both match then get the defined role for user from database and continue; else return isAllowed [false]
        //Access the database and do this part yourself
        //String userRole = userMgr.getUserRole(username);
        //String userRole = "admin";
         
        //Step 2. Verify user role
        if(rolesSet.contains(role))
        {
            isAllowed = true;
        }
        return isAllowed;
    }

}
