package com.spring.security.springsecurity.resource;

import javax.inject.Named;
import javax.ws.rs.core.Response;

@Named
public class UserResourceImpl implements UserResource{
    @Override
    public Response Hello() {
       String welcome =  "Welcome";
       return Response.status(Response.Status.OK).entity(welcome).build();
    }

    @Override
    public Response getUser() {
        String welcome =  "Welcome User";
        return Response.status(Response.Status.OK).entity(welcome).build();
    }

    @Override
    public Response getAdmin() {
        String welcome =  "Welcome Admin";
        return Response.status(Response.Status.OK).entity(welcome).build();
    }
}
