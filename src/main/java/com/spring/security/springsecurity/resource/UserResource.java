package com.spring.security.springsecurity.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface UserResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/hello")
    Response Hello();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/user")
    Response getUser();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/admin")
    Response getAdmin();
}
