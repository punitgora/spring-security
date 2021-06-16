package com.spring.security.springsecurity.resource;

import com.spring.security.springsecurity.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public interface UserResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    Response getUser();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{email}")
    Response getUserByEmail(@PathParam(value = "email") String email);

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    Response createUser(UserModel userModel);

}
