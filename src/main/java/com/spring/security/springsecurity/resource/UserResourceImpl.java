package com.spring.security.springsecurity.resource;

import com.spring.security.springsecurity.entity.UserEntity;
import com.spring.security.springsecurity.model.UserModel;
import com.spring.security.springsecurity.repository.UserDao;
import org.springframework.core.convert.ConversionService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

@Named
public class UserResourceImpl implements UserResource{

    @Inject
    private ConversionService conversionService;

    @Inject
    UserDao userDao;

    @Override
    public Response getUser() {
        return Response.ok().entity("Hello").build();
    }

    @Override
    public Response getUserByEmail(String email) {
        UserEntity userEntity = userDao.getUserByEmail(email);
        return Response.ok().entity(conversionService.convert(userEntity, UserModel.class)).build();

    }

    @Override
    public Response createUser(UserModel userModel) {
        UserEntity userEntity = conversionService.convert(userModel, UserEntity.class);
        userDao.saveOrUpdate(userEntity);
        return Response.ok().entity(userModel).build();
    }
}
