package com.spring.security.springsecurity.exception.handler;

import com.spring.security.springsecurity.error.Error;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Component
@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        Error error = new Error("INTERNAL_SERVER_ERROR", "An internal service error has occured");
        Response response = Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        return response;
    }
}
