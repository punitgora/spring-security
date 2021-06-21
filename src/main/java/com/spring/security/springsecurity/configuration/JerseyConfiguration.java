package com.spring.security.springsecurity.configuration;

import com.spring.security.springsecurity.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

@Named
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        packages("com.spring.security.springsecurity");
        register(UserResource.class);
    }
}
