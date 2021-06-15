package com.spring.security.springsecurity.configuration;

import com.spring.security.springsecurity.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

@Named
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(UserResource.class);
    }
}
